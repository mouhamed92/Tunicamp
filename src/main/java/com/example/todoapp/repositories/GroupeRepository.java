package com.example.todoapp.repositories;

import com.example.todoapp.models.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeRepository extends MongoRepository<Groupe,String> {
}
