package com.codingforfun.calculator;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

// A calculator must implement ICalculator
public class NextNumberForYearCalculator implements ICalculator {

    // This value will be injected (using its setter) before calculating
    @Getter
    @Setter
    private int year;

    // It does the calculation
    @Override
    public Object calculate() throws Exception {
        //A JAP Query
        Query query = XPersistence.getManager().createQuery("select max(i.number) from Invoice i where i.year = :year");
        // We use the injected year as a parameter for the query
        query.setParameter("year", year);

        Integer lastNumber = (Integer)query.getSingleResult();
        // Returns the last invoice number of the year + 1 or 1 if there is no last number
        return lastNumber == null ? 1: lastNumber + 1;
    }
}
