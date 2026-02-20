package com.example.demo.repository.mongo;

import com.example.demo.model.mongo.HorarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioMongoRepository extends MongoRepository<HorarioMongo, String> {
}
