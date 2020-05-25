package com.codingforfun.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Category extends Identifiable{


    @Column(length = 50)
    private String description;



    public String getDescription() {
        System.out.println("This is get Method in Category Entity");
        return description;
    }

    public void setDescription(String description) {
        System.out.println("This is set Method in Category Entity");

        this.description = description;
    }



}
