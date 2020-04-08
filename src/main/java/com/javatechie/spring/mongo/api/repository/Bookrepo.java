package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Book;

public interface Bookrepo extends MongoRepository<Book, Integer> {

}
