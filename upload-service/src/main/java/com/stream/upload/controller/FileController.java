package com.stream.upload.controller;

import com.stream.upload.payload.FileResponse;
import com.stream.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${project.files}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            FileResponse fileResponse = this.fileService.uploadFile(path, file);
            return ResponseEntity.status(HttpStatus.OK).body(fileResponse);
        } catch (IOException e) {
            e.printStackTrace();
            // In case of an error, return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FileResponse(null, null, "File Uploaded ERROR"));
        }
    }
}
