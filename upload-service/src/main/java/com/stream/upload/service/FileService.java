package com.stream.upload.service;

import com.stream.upload.payload.FileResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {

    FileResponse uploadFile(String path , MultipartFile file) throws IOException;

}
