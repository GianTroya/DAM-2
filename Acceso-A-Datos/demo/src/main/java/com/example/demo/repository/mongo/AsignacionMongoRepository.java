package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.AsignacionMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsignacionMongoRepository extends MongoRepository<AsignacionMongo, String> {
}
