package com.codingforfun.model.test;

import com.codingforfun.model.Customer;
import com.codingforfun.model.Identifiable;
import lombok.Data;
import org.junit.Test;
import org.openxava.annotations.*;
import org.openxava.calculators.StringCalculator;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Test2 extends Identifiable {



        @ManyToOne
        private Test1 test1;


        @ManyToOne
        @DescriptionsList
        @DefaultValueCalculator(value = StringCalculator.class, properties = @PropertyValue(name="string", value="helloworld"))
        private Customer customer;

        public Customer getCustomer() {
                System.out.println("This is getCustomer Method" + test1 + " --" + test1.getCustomer());

                System.out.println("This is customer" + customer);
                return test1.getCustomer();

        }

        public void setCustomer(Customer customer) {
                System.out.println("This is set method to set values" + customer);
                this.customer = customer;
        }



}
