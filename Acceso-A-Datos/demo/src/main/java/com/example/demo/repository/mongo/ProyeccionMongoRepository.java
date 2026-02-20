package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.ProyeccionMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProyeccionMongoRepository extends MongoRepository<ProyeccionMongo, String> {
}
