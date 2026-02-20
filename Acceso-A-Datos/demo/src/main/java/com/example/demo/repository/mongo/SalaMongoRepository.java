package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.SalaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalaMongoRepository extends MongoRepository<SalaMongo, String> {
}
