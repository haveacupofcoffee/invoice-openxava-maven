package com.codingforfun.model;

import lombok.Data;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {

    @Id
    @Column(length = 9)
    private int number;

    @Column(length = 50)
    @Required
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Category category;

    @Stereotype("MONEY")
    private BigDecimal price;

    @Stereotype("IMAGES_GALLERY")
    @Column(length = 32)
    private String photos;

    @Stereotype("MEMO")
    private String remarks;
}
