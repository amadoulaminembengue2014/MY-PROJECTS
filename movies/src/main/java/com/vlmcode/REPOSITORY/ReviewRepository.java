package com.vlmcode.REPOSITORY;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vlmcode.ENTITY.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
