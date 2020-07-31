package com.codingforfun.model.test;

import com.codingforfun.model.Identifiable;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.annotations.Tab;
import org.openxava.annotations.Tabs;

import javax.persistence.*;
import java.util.Date;
import java.util.logging.Logger;

@Data
@Entity
@Table(name = "test_call_back")
public class TestCallBack extends Identifiable {

    private static Log log = LogFactory.getLog(TestCallBack.class);

    @Column(length = 20)
    private String name;

    @Column(length = 3)
    private int age;

    @Column(name = "birth_date")
    private Date birthDate;

    @PrePersist
    public void onPrePersist() {
        System.out.println("This is onPrePersist Method");
        System.out.println("TestCallBack : " + this.toString());
    }

    @PreUpdate
    public void onPreUpdate() {
        System.out.println("This is onPreUpdate Method");
        System.out.println("TestCallBack : " + this.toString());
    }




}
