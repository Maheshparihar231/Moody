package com.stream.upload.service;

import com.stream.upload.payload.FileResponse;
import com.stream.upload.repository.FileResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileResponseRepository fileResponseRepository;

    @Override
    public FileResponse uploadFile(String path, MultipartFile file) throws IOException {
        // Get the original file name
        String originalFileName = file.getOriginalFilename();

        // Create a new FileResponse entity and save it to MongoDB
        FileResponse fileResponse = new FileResponse();
        fileResponse.setFileName(originalFileName);
        fileResponse.setMessage("File Uploaded Success");
        fileResponseRepository.save(fileResponse);

        // Use the MongoDB-generated ID as the file name
        String id = fileResponse.getId();

        // Build the full file path
        String filePath = path + File.separator + id;

        // Create the folder if it doesn't exist
        File fileDirectory = new File(path);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }

        // Upload the file with the MongoDB ID as the name
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileResponse;
    }
}

