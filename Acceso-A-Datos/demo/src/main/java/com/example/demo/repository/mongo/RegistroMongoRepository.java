package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.RegistroMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroMongoRepository extends MongoRepository<RegistroMongo, String> {
}
