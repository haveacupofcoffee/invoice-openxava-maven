package com.codingforfun.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.View;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@View(extendsView = "super.DEFAULT",
      members = "orders {orders}"
)

@View(name = "NoCustomerNoOrders",
    members =
            "year, number, date;" +
             "details;" +
             "remarks"
)

@Data
@Entity
public class Invoice extends CommercialDocument {

    @ElementCollection
    @ListProperties("product.number, product.description, quantity, pricePerUnit, " +
            "amount[invoice.baseAmount, invoice.vat, invoice.totalAmount] ")
    private Collection<Detail> details;

    @OneToMany(mappedBy = "invoice")
    @CollectionView("NoCustomerNoInvoice")
    private Collection<Order> orders;

    @Override
    public Collection<Detail> getDetails() {
        return details;
    }

/*    @Override
    public Collection<Detail> getDetails() {
        return details;
    }*/


}