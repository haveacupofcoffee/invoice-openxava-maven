package com.codingforfun.schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("SecondTask")
public class SecondTask {

    public void nowDate() {
        // Some useful stuff you want to do regularly
        System.out.println("now  Date from nowDate() "  + new Date());
    }

}
