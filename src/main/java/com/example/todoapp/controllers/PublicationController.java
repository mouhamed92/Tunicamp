package com.example.todoapp.controllers;

import com.example.todoapp.models.Publication;
import com.example.todoapp.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;



    @GetMapping("/publications")
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PostMapping("/publications")
    public Publication createPublication(@Valid @RequestBody Publication publication) {
        System.out.println("creation publication");
        return publicationRepository.save(publication);
    }

    @GetMapping(value="/publications/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable("id") String id) {
        return publicationRepository.findById(id)
                .map(publication -> ResponseEntity.ok().body(publication))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/publications/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable("id") String id,
                                           @Valid @RequestBody Publication publication) {
        return publicationRepository.findById(id)
                .map(publicationData -> {
                    publicationData.setName(publication.getName());
                    publicationData.setContext(publication.getContext());

                    Publication updatedPublication = publicationRepository.save(publicationData);
                    return ResponseEntity.ok().body(updatedPublication);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/publications/{id}")
    public ResponseEntity<?> deletePublication(@PathVariable("id") String id) {
        return publicationRepository.findById(id)
                .map(publication -> {
                    publicationRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}