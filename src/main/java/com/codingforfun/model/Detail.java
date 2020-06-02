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


    @DefaultValueCalculator(value = PricePerUnitCalculator.class,
        properties = @PropertyValue(name  = "productNumber", from = "product.number"))
    @Stereotype("MONEY")
    private BigDecimal pricePerUnit;

    public BigDecimal getPricePerUnit() {
        return pricePerUnit == null ? BigDecimal.ZERO : pricePerUnit;
    }


    @Stereotype("MONEY")
    @Depends("pricePerUnit, quantity")
    public BigDecimal getAmount() {
        return new BigDecimal(quantity).multiply(getPricePerUnit());
    }


}
