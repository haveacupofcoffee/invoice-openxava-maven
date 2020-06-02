package com.codingforfun.calculator;

import com.codingforfun.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

public class PricePerUnitCalculator implements ICalculator {

    @Getter
    @Setter
    private int productNumber;

    @Override
    public Object calculate() throws Exception {
        Product product = XPersistence.getManager().find(Product.class, productNumber);
        return product.getPrice();
    }
}
