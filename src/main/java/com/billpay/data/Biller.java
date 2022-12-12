package com.billpay.data;

import javax.persistence.*;

@Entity
@Table
public class Biller {

    @Id
    private Integer id;

    public enum Utility{
        ELECTRICITY_BILL,
        WIFI_BILL,
        WATER_BILL;
    }

    @Enumerated(EnumType.STRING)
    @Column
    private Utility utility;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utility getUtility() {
        return utility;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }
}
