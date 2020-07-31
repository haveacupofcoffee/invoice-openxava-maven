package com.codingforfun.model.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class TestLocation {

    @Column(length = 20)
    private String name;
}
