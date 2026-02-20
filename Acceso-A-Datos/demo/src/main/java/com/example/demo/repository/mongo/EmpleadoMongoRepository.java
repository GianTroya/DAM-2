package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.EmpleadoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoMongoRepository extends MongoRepository<EmpleadoMongo, String> {
}
