package com.example.todoapp.models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="publications")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Publication {
    @Id
    private String id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
    private String name;
    private String context;


    private Date createdAt = new Date();

    public Publication() {
        super();
    }

    public Publication(String name,String context) {
        this.name = name;
        this.context = context;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublication() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPublication(String name) {
        this.name = name;
    }
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }






    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, name='%s', context='%s']",
                id, name, context);
    }
}
