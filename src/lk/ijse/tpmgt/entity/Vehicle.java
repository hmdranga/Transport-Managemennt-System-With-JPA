/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author A C E R
 */
@Entity
public class Vehicle {
    @Id
    private String regNo;
    private String brand;
    private String colour;
    @Temporal(TemporalType.DATE)
    private Date boughtDate;

    @OneToMany(mappedBy = "vehicle",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private
    List<TripDetail> tripDetails =new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private
    List<ExpenceDetail> expenceDetails = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String regNo, String brand, String colour, Date boughtDate) {
        this.regNo = regNo;
        this.brand = brand;
        this.colour = colour;
        this.boughtDate = boughtDate;
    }

    /**
     * @return the regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @param regNo the regNo to set
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return the boughtDate
     */
    public Date getBoughtDate() {
        return boughtDate;
    }

    /**
     * @param boughtDate the boughtDate to set
     */
    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "regNo=" + regNo + ", brand=" + brand + ", colour=" + colour + ", boughtDate=" + boughtDate + '}';
    }

    public List<TripDetail> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(List<TripDetail> tripDetails) {
        this.tripDetails = tripDetails;
    }

    public List<ExpenceDetail> getExpenceDetails() {
        return expenceDetails;
    }

    public void setExpenceDetails(List<ExpenceDetail> expenceDetails) {
        this.expenceDetails = expenceDetails;
    }
}
