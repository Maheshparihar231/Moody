package com.stream.upload.service;

import com.stream.upload.payload.FileResponse;
import com.stream.upload.repository.FileResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileResponseRepository fileResponseRepository;

    @Value("${project.files}")
    private String path;

    @Override
    public FileResponse uploadFile(String path, MultipartFile file , String userId) throws IOException {
        // Get the original file name
        String originalFileName = file.getOriginalFilename();

        // Create a new FileResponse entity and save it to MongoDB
        FileResponse fileResponse = new FileResponse();
        fileResponse.setFileName(originalFileName);
        fileResponse.setMessage("File Uploaded Success");
        fileResponseRepository.save(fileResponse);

        // Use the MongoDB-generated ID as the file name
        String id = fileResponse.getId();

        // Build the full file path with user specific folder
        String userFolderPath = path + File.separator + userId;
        String filePath = userFolderPath + File.separator + id;

        // Create the folder if it doesn't exist
        File fileDirectory = new File(userFolderPath);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }

        // Upload the file with the MongoDB ID as the name
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileResponse;
    }

    @Override
    public String getFilePath(String userId, String fileId) {
        return path + File.separator + userId + File.separator + fileId;
    }

    @Override
    public Resource loadFileAsResource(String filePath) throws IOException {
        Path file = Paths.get(filePath);
        Resource resource = new UrlResource(file.toUri());

        if(resource.exists() || resource.isReadable()){
            return resource;
        }else {
            throw new FileNotFoundException("File not found" + filePath);
        }

    }
}

