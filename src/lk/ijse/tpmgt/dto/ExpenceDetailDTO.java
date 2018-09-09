/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author A C E R
 */
public class ExpenceDetailDTO {
    private String regNo;
    private String exId;
    private Date date;
    private BigDecimal amount;
    private String description;

    public ExpenceDetailDTO() {
    }

    public ExpenceDetailDTO(String regNo, String exId, Date date, BigDecimal amount, String description) {
        this.regNo = regNo;
        this.exId = exId;
        this.date = date;
        this.amount = amount;
        this.description = description;
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
        return "ExpenceDetailDTO{" + "regNo=" + getRegNo() + ", exId=" + getExId() + ", date=" + getDate() + ", amount=" + getAmount() + ", description=" + getDescription() + '}';
    }

    /**
     * @return the exId
     */
    public String getExId() {
        return exId;
    }

    /**
     * @param exId the exId to set
     */
    public void setExId(String exId) {
        this.exId = exId;
    }

   
    
}
