package com.zto.scott.componentorder;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Scott on 2018/1/11.
 */
@Entity
public class Order {
    @Id(autoincrement = true)
    Long id;
    double price;
    @Generated(hash = 1657835637)
    public Order(Long id, double price) {
        this.id = id;
        this.price = price;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
