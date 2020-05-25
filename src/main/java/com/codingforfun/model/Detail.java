package com.codingforfun.model;

import lombok.Data;
import org.openxava.annotations.Depends;
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

    @Stereotype("MONEY")
    @Depends("product.numer, quantity")
    public BigDecimal getAmount() {
        return new BigDecimal(quantity).multiply(product.getPrice());
    }
}
