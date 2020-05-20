package com.codingforfun.model;

import com.codingforfun.calculator.NextNumberForYearCalculator;
import lombok.Data;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;



@View(members =
    "year, number, date;" +
     "customer;" +
     "details;" +
     "remarks"
)

@Data
@Entity
public class Invoice extends Identifiable{

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int year;


    // To inject the value of year from Invoice to
    // the calculator before calling to calculate()
    @Column(length = 6)
    @DefaultValueCalculator(value = NextNumberForYearCalculator.class,
            properties = @PropertyValue(name="year"))
    private int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate date;

    // Customer is required
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")  // The view named 'Simple' is used to display this reference
    private Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    private Collection<Detail> details;

    @Stereotype("MEMO")
    private String remarks;

}
