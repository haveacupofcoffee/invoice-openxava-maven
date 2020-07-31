package com.codingforfun.model.test;

import com.codingforfun.model.Identifiable;
import com.codingforfun.model.Product;
import lombok.Data;
import org.openxava.annotations.CollectionViews;
import org.openxava.annotations.ListProperties;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;


@Entity
@Data
@Table(name = "test_author")
public class TestAuthor extends Identifiable {

    @Column(length = 20)
    private String name;

    @ElementCollection
    @ListProperties(value = "testProduct.id, testProduct.description")
    private Collection<TestDetail> details;

}
