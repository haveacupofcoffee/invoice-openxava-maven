package com.codingforfun.model;

import com.codingforfun.calculator.PricePerUnitCalculator;
import lombok.Data;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Depends;
import org.openxava.annotations.PropertyValue;
import org.openxava.annotations.Stereotype;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
@Data
public class Detail {

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Product product;

    @DefaultValueCalculator(value = PricePerUnitCalculator.class,   // This class calculates the initial value
            properties = @PropertyValue(name="productNumber", // The productNumber property of the calculator...
                    from = "product.number"))  // ...is filled from product.number of the detail
    private BigDecimal pricePerUnit;

    public BigDecimal getPricePerUnit() {
        System.out.println("pricePerUnit getter: " + pricePerUnit);
        return pricePerUnit ==null ? BigDecimal.ZERO : pricePerUnit;  // Thus never returns null
    }

    @Stereotype("MONEY")
    @Depends("pricePerUnit, quantity")   // pricePerUnit instead of product.number
    public BigDecimal getAmount() {
        return new BigDecimal(quantity).multiply(getPricePerUnit());  // getPricePerUnit() instead of product.getPrice()
    }
}
