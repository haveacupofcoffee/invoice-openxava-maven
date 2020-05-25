package com.codingforfun.model;

import lombok.Data;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import java.util.Collection;

@Data
@Entity
public class Author extends Identifiable {


    @Column(length = 50)
    @Required
    private String name;
    /**
     * doesn't show in List mode
     */
    @OneToMany(mappedBy = "author")
    @ListProperties("number, description, price")
    private Collection<Product> products;
}
