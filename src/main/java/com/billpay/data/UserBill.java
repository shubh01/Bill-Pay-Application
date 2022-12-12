package com.billpay.data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class UserBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private UserDetails userDetails;

    @ManyToOne
    private Biller biller;

    private Double dueAmount;

    private Date billGenerationDate;

    private Date billPaymentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Biller getBiller() {
        return biller;
    }

    public void setBiller(Biller biller) {
        this.biller = biller;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Date getBillGenerationDate() {
        return billGenerationDate;
    }

    public void setBillGenerationDate(Date billGenerationDate) {
        this.billGenerationDate = billGenerationDate;
    }

    public Date getBillPaymentDate() {
        return billPaymentDate;
    }

    public void setBillPaymentDate(Date billPaymentDate) {
        this.billPaymentDate = billPaymentDate;
    }
}
