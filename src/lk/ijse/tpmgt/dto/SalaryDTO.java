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
public class SalaryDTO {
    
    private String sId;
    private Date sDate;
    private BigDecimal totalKm;
    private BigDecimal bonus;
    private BigDecimal amountPerKm;
    private BigDecimal earn;
    private BigDecimal total;
    private String nic;

    public SalaryDTO() {
    }

    public SalaryDTO(String sId, Date sDate, BigDecimal totalKm, BigDecimal bonus, BigDecimal amountPerKm, BigDecimal earn, BigDecimal total, String nic) {
        this.sId = sId;
        this.sDate = sDate;
        this.totalKm = totalKm;
        this.bonus = bonus;
        this.amountPerKm = amountPerKm;
        this.earn = earn;
        this.total = total;
        this.nic = nic;
    }

    
    

    
    /**
     * @return the sId
     */
    public String getsId() {
        return sId;
    }

    /**
     * @param sId the sId to set
     */
    public void setsId(String sId) {
        this.sId = sId;
    }

    /**
     * @return the sDate
     */
    public Date getsDate() {
        return sDate;
    }

    /**
     * @param sDate the sDate to set
     */
    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    
    /**
     * @return the bonus
     */
    public BigDecimal getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the amountPerKm
     */
    public BigDecimal getAmountPerKm() {
        return amountPerKm;
    }

    /**
     * @param amountPerKm the amountPerKm to set
     */
    public void setAmountPerKm(BigDecimal amountPerKm) {
        this.amountPerKm = amountPerKm;
    }

    /**
     * @return the earn
     */
    public BigDecimal getEarn() {
        return earn;
    }

    /**
     * @param earn the earn to set
     */
    public void setEarn(BigDecimal earn) {
        this.earn = earn;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the totalKm
     */
    public BigDecimal getTotalKm() {
        return totalKm;
    }

    /**
     * @param totalKm the totalKm to set
     */
    public void setTotalKm(BigDecimal totalKm) {
        this.totalKm = totalKm;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" + "sId=" + getsId() + ", sDate=" + getsDate() + ", totalKm=" + getTotalKm() + ", bonus=" + getBonus() + ", amountPerKm=" + getAmountPerKm() + ", earn=" + getEarn() + ", total=" + getTotal() + ", nic=" + getNic() + '}';
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    
   
}
