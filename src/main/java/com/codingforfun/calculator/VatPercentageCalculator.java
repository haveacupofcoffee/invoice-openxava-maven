package com.codingforfun.calculator;

import com.codingforfun.util.InvoicingPreferences;
import org.openxava.calculators.ICalculator;

public class VatPercentageCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return InvoicingPreferences.getDefaultVatPercentage();
    }
}
