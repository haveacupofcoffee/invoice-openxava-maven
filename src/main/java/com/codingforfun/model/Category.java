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

}
