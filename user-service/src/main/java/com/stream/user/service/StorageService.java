package com.stream.user.service;

import com.stream.user.model.ImageData;
import com.stream.user.repository.StorageRepository;
import com.stream.user.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException{
        ImageData imageData = storageRepository.save(ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());
        if(imageData!=null){
            return "File Uploaded Successfully";
        }
        return null;
    };

    public byte[] downloadImage(String name){
        Optional<ImageData> imageData = storageRepository.findByName(name);
        byte[] image = ImageUtils.decompressImage(imageData.get().getImageData());
        return image;
    };
}
