package com.codingforfun.model;

import com.codingforfun.calculator.VatPercentageCalculator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;


@View(members =
    "year, number, date, vatPercentage;" +  //vatPercentage added
    "data {" +
        "customer;" +
        "details;" +
        "remarks;" +
    "}"
)

@Data
@Entity
abstract public class CommercialDocument extends Identifiable{

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int year;


    // To inject the value of year from CommercialDocument to
    // the calculator before calling to calculate()
    @Column(length = 6)
   /* @DefaultValueCalculator(value = NextNumberForYearCalculator.class,
            properties = @PropertyValue(name="year"))*/
   @ReadOnly
    private int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate date;

    @Digits(integer = 2, fraction = 0)
    @Required
    @DefaultValueCalculator(VatPercentageCalculator.class)
    private BigDecimal vatPercentage;

    // Customer is required
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")  // The view named 'Simple' is used to display this reference
    private Customer customer;

/*    @ElementCollection
    @ListProperties("product.number, product.description, quantity, pricePerUnit, " +
            "amount[invoice.baseAmount, invoice.vat, invoice.totalAmount] ")
    private Collection<Detail> details;*/

    @Stereotype("MONEY")
    private BigDecimal amount;


    @Stereotype("MEMO")
    private String remarks;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Version
    private int version;

    public BigDecimal getVatPercentage() {
        return vatPercentage == null ? BigDecimal.ZERO : vatPercentage;  //never return null;
    }

    public abstract  Collection<Detail> getDetails();

    public BigDecimal getBaseAmount() {
        BigDecimal result = new BigDecimal("0.00");
        System.out.println("getBaseAmount()" + getDetails());
        for(Detail detail : getDetails()) {   //iterate all details
            result = result.add(detail.getAmount());   //Adding up the amount
        }

        return result;
    }

    public BigDecimal getVat() {
        //baseAmount * vatPercentage / 100
        return getBaseAmount().multiply(getVatPercentage()).divide(new BigDecimal("100"));
    }

    public BigDecimal getTotalAmount() {
        //baseAmount + vat
        return getBaseAmount().add(getVat());
    }



    public void calculateNumber() throws Exception {
        Query query = XPersistence.getManager().createQuery("select max(i.number) from " +
                getClass().getSimpleName() +    //It's valid for both Invoice and Order
                " i where i.year = :year");
        query.setParameter("year", year);
        Integer lastNumber = (Integer)query.getSingleResult();
        this.number = lastNumber == null ? 1 : lastNumber + 1;
    }

    @PrePersist    // Executed just before saving the object for the first timet
    private void onPrePersist() throws Exception {
        System.out.println("onPrePersist Method ------------- ");
        calculateNumber();
        recalculateAmount();

    }

    @PreUpdate
    private void recalculateAmount() {
        System.out.println("recalculateAmount Method ------------- ");
        setAmount(getTotalAmount());
    }







}
