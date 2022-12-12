package com.billpay.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class BillerWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private UserDetails lastModifiedBy;

    @OneToOne
    @JoinColumn
    private Biller billerId;

    private Double amountCredit;

    private Date lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDetails getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(UserDetails lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Biller getBillerId() {
        return billerId;
    }

    public void setBillerId(Biller billerId) {
        this.billerId = billerId;
    }

    public Double getAmountCredit() {
        return amountCredit;
    }

    public void setAmountCredit(Double amountCredit) {
        this.amountCredit = amountCredit;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
