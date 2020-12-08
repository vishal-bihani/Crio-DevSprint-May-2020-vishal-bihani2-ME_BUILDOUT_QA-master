package com.crio.buildouts.repository;

import com.crio.buildouts.models.QuestionEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<QuestionEntity, String> {

}