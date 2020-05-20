package com.codingforfun.model;


import lombok.Data;
import org.openxava.annotations.Stereotype;

import javax.persistence.Entity;


public class Template extends Identifiable {

    @Stereotype("PERSON_NAME")
    private String name;

}
