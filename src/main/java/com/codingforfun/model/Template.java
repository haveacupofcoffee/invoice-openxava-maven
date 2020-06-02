package com.codingforfun.model;


import lombok.Data;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.hibernate.validator.constraints.Length;
import org.openxava.annotations.DisplaySize;
import org.openxava.annotations.Stereotype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

@Entity
@Data
public class Template extends Identifiable {

    @Stereotype("PERSON_NAME")
    private String name;

    @Length(min = 3, max = 3, message = "currency_code_not_three_characters")
    @Column(length = 3)
    private String code;


}
