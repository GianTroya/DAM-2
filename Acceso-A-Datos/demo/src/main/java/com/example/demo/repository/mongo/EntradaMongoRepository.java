package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.EntradaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradaMongoRepository extends MongoRepository<EntradaMongo, String> {
}
