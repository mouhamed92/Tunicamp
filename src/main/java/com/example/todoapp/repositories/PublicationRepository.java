package com.example.todoapp.repositories;

import com.example.todoapp.models.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<Publication, String> {

}
