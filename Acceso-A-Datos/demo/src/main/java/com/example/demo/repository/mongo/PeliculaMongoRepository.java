package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.PeliculaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeliculaMongoRepository extends MongoRepository<PeliculaMongo, String> {
}
