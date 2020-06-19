package com.example.todoapp.controllers;
import com.example.todoapp.models.Groupe;
import com.example.todoapp.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GroupeController {

    @Autowired
   GroupeRepository groupeRepository;



    @GetMapping("/groupes")
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PostMapping("/groupes")
    public Groupe createGroupe(@Valid @RequestBody Groupe groupe) {
        System.out.println("creation groupe");
        return groupeRepository.save(groupe);
    }

    @GetMapping(value="/groupes/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") String id) {
        return groupeRepository.findById(id)
                .map(groupe -> ResponseEntity.ok().body(groupe))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/groupes/{id}")
    public ResponseEntity<Groupe> updateGroupe(@PathVariable("id") String id,
                                                         @Valid @RequestBody Groupe groupe) {
        return groupeRepository.findById(id)
                .map(groupeData -> {
                    groupeData.setName(groupe.getName());
                    groupeData.setContext(groupe.getContext());

                    Groupe updatedGroupe = groupeRepository.save(groupeData);
                    return ResponseEntity.ok().body(updatedGroupe);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/groupes/{id}")
    public ResponseEntity<?> deleteGroupe(@PathVariable("id") String id) {
        return groupeRepository.findById(id)
                .map(groupe -> {
                    groupeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}