package com.codingforfun.model.test;

import com.codingforfun.model.Customer;
import com.codingforfun.model.Identifiable;
import lombok.Data;
import org.openxava.annotations.Required;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.temporal.ChronoUnit;

@Entity
@Data
public class Test1 extends Identifiable {

    @Required
    private String name;

    @ManyToOne
    @Required
    private Customer customer;



}
