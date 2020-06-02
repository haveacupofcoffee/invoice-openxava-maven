package com.codingforfun.schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("busRoutesPumpService")
public class BusRoutesPump {

    public void pump() {
        // Some useful stuff you want to do regularly
        System.out.println("now Date from pump(): "  + new Date());
    }

}
