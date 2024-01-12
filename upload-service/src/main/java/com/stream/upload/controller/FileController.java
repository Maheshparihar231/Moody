package com.stream.upload.controller;

import com.stream.upload.payload.FileResponse;
import com.stream.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${project.files}")
    private String path;

    @PostMapping("/upload/{userId}")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("file") MultipartFile file , @PathVariable String userId) {
        try {
            FileResponse fileResponse = this.fileService.uploadFile(path, file,userId);
            return ResponseEntity.status(HttpStatus.OK).body(fileResponse);
        } catch (IOException e) {
            e.printStackTrace();
            // In case of an error, return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FileResponse(null, null, "File Uploaded ERROR"));
        }
    }

    @GetMapping("/view/{userId}/{fileId}")
    public ResponseEntity<Resource> viewFile(@PathVariable String userId, @PathVariable String fileId){
        try {
            String filePath = fileService.getFilePath(userId , fileId);
            Resource resource = fileService.loadFileAsResource(filePath);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
