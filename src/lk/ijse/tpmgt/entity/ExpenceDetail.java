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
public class ExpenceDetail {
    @EmbeddedId
    private ExpenceDetail_PK expenceDetail_pk;
    @Temporal(TemporalType.DATE)
    private Date date;
    private BigDecimal amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vehicleRegNo" ,referencedColumnName = "regNo",insertable = true,updatable = true)
    private
    Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "expenceTypeId",referencedColumnName = "exId",insertable = true,updatable = true)
    private
    ExpenceType expenceType;

    public ExpenceDetail(ExpenceDetail_PK expenceDetail_pk, Date date, BigDecimal amount, String description) {
        this.expenceDetail_pk = expenceDetail_pk;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    
    public ExpenceDetail(String regNo, String exId, Date date, BigDecimal amount, String description) {
        this.expenceDetail_pk = new ExpenceDetail_PK(regNo, exId);
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    
    public ExpenceDetail() {
    }

    /**
     * @return the expenceDetail_pk
     */
    public ExpenceDetail_PK getExpenceDetail_pk() {
        return expenceDetail_pk;
    }

    /**
     * @param expenceDetail_pk the expenceDetail_pk to set
     */
    public void setExpenceDetail_pk(ExpenceDetail_PK expenceDetail_pk) {
        this.expenceDetail_pk = expenceDetail_pk;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExpenceDetail{" + "expenceDetail_pk=" + expenceDetail_pk + ", date=" + date + ", amount=" + amount + ", description=" + description + '}';
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ExpenceType getExpenceType() {
        return expenceType;
    }

    public void setExpenceType(ExpenceType expenceType) {
        this.expenceType = expenceType;
    }
}
