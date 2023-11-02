package com.stream.user.repository;

import com.stream.user.model.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StorageRepository extends MongoRepository<ImageData,String> {
    Optional<ImageData> findByName(String name);
}
