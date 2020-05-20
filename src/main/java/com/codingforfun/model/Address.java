package com.codingforfun.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {

    @Column(length = 30)
    private String street;

    @Column(length = 7)
    private String zipCode;

    @Column(length = 20)
    private String city;

    @Column(length = 30)
    private String state;
}
