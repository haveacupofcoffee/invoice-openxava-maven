package com.codingforfun.model.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class TestDetail {

    @Column(length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private TestProduct testProduct;
}
