package com.example.masterhibernateandjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee(){

    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
