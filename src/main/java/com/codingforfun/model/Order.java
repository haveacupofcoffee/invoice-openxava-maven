package com.codingforfun.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Collection;

@View(extendsView = "super.DEFAULT", members = "invoice {invoice}")
@View(name = "NoCustomerNoInvoice",
    members =
            "year, number, date;" +
            "details;" +
            "remarks"
)
@Data
@Entity
public class Order extends CommercialDocument {


    @ElementCollection
    @ListProperties("product.number, product.description, quantity, pricePerUnit, " +
            "amount[order.baseAmount, order.vat, order.totalAmount] ")
    private Collection<Detail> details;

    @ManyToOne
    @ReferenceView("NoCustomerNoOrders")
    private Invoice invoice;

    @Override
    public Collection<Detail> getDetails() {
        return details;
    }
/*
    @Override
    public Collection<Detail> getDetails() {
        return details;
    }*/
}
