package com.example.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Plant {

    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;

    @NotNull
    @Size(min = 4, message = "Name must at least be greater than 4 characters")
    private String name;

    @NotNull
    private Float height;

    // --- Getters and Setters --- //

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

    public Float getHeight() {
        return height;
    }
    public void setHeight(Float height) {
        this.height = height;
    }

}
