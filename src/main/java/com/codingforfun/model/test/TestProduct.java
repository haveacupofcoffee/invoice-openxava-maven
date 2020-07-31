package com.codingforfun.model.test;

import com.codingforfun.model.Author;
import com.codingforfun.model.Category;
import com.codingforfun.model.Identifiable;
import lombok.Data;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "test_product")
public class TestProduct extends Identifiable {


    @Column(length = 50)
    @Required
    private String description;



}
