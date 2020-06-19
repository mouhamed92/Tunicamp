package com.example.todoapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection="groupes")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Groupe {
    @Id
    private String id ;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name ;
    private String Context ;

    public Groupe() {
    }

    public Groupe(String id, String name, String context) {
        this.id = id;
        this.name = name;
        Context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id='" + id + '\'' +
                ", nom='" + name + '\'' +
                ", Context='" + Context + '\'' +
                '}';
    }
}
