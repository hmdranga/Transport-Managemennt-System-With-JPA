/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author A C E R
 */
@Entity
@Table(name = "Salary")
public class Salary {
    @Id
    private String sId;
    @Temporal(TemporalType.DATE)
    private Date sDate;
    private BigDecimal totalKm;
    private BigDecimal bonus;
    private BigDecimal amountPerKm;
    private BigDecimal earn;
    private BigDecimal total;
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId",referencedColumnName = "nic")
    private Driver driver;

    public Salary() {
    }

    public Salary(String sId, Date sDate, BigDecimal totalKm, BigDecimal bonus, BigDecimal amountPerKm, BigDecimal earn, BigDecimal total, Driver driver) {
        this.sId = sId;
        this.sDate = sDate;
        this.totalKm = totalKm;
        this.bonus = bonus;
        this.amountPerKm = amountPerKm;
        this.earn = earn;
        this.total = total;
        this.driver = driver;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public BigDecimal getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(BigDecimal totalKm) {
        this.totalKm = totalKm;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getAmountPerKm() {
        return amountPerKm;
    }

    public void setAmountPerKm(BigDecimal amountPerKm) {
        this.amountPerKm = amountPerKm;
    }

    public BigDecimal getEarn() {
        return earn;
    }

    public void setEarn(BigDecimal earn) {
        this.earn = earn;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sId='" + sId + '\'' +
                ", sDate=" + sDate +
                ", totalKm=" + totalKm +
                ", bonus=" + bonus +
                ", amountPerKm=" + amountPerKm +
                ", earn=" + earn +
                ", total=" + total +
                ", driver=" + driver +
                '}';
    }
}
