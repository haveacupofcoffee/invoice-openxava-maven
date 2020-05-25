package com.codingforfun.model;

import lombok.Data;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


@View(name="Simple", members = "number, name")
@Data
@Entity
public class Customer {

    @Id
    @Column(length = 6)
    private int number;

    @Column(length = 50)
    @Required
    private String name;

    @Embedded
    private Address address;

    public Address getAddress() {
        return address == null? new Address():address;
    }


}
