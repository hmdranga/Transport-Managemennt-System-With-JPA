




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
public class TripDetail {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private BigDecimal start;
    
    private BigDecimal end;
    @ManyToOne
    @JoinColumn(name = "vehicleRegNo",referencedColumnName = "regNo",insertable = true,updatable = true)
    private
    Vehicle vehicle;
    //private String regNo;

    @ManyToOne
    @JoinColumn(name = "driverNic",referencedColumnName = "nic",insertable = true,updatable = true)
    private
    Driver driver;


    public TripDetail() {
    }

    public TripDetail(String id, Date date, BigDecimal start, BigDecimal end, Vehicle vehicle, Driver driver) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.vehicle = vehicle;
        this.driver = driver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getStart() {
        return start;
    }

    public void setStart(BigDecimal start) {
        this.start = start;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    @Override
    public String toString() {
        return "TripDetail{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", start=" + start +
                ", end=" + end +
                ", vehicle=" + vehicle +
                ", driver=" + driver +
                '}';
    }
}
