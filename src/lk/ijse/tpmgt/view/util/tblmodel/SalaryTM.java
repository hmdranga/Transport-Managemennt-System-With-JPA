/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.view.util.tblmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author A C E R
 */
public class SalaryTM {
    
    private String sId;
    private String nic;
    private Date sDate;
    private BigDecimal amountPerKm;
    private BigDecimal totalKm;
    private BigDecimal earn;
    private BigDecimal bonus;
    private BigDecimal total;

    public SalaryTM() {
    }

    public SalaryTM(String sId, String nic, Date sDate, BigDecimal amountPerKm, BigDecimal totalKm, BigDecimal earn, BigDecimal bonus, BigDecimal total) {
        this.sId = sId;
        this.nic = nic;
        this.sDate = sDate;
        this.amountPerKm = amountPerKm;
        this.totalKm = totalKm;
        this.earn = earn;
        this.bonus = bonus;
        this.total = total;
    }

    
    /**
     * @return the sId
     */
    public String getSId() {
        return sId;
    }

    /**
     * @param sId the sId to set
     */
    public void setsId(String sId) {
        this.sId = sId;
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

    /**
     * @return the sDate
     */
    public Date getSDate() {
        return sDate;
    }

    /**
     * @param sDate the sDate to set
     */
    public void setsDate(Date sDate) {
        this.sDate = sDate;
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

    @Override
    public String toString() {
        return "SalaryTM{" + "sId=" + sId + ", nic=" + nic + ", sDate=" + sDate + ", amountPerKm=" + amountPerKm + ", totalKm=" + totalKm + ", earn=" + earn + ", bonus=" + bonus + ", total=" + total + '}';
    }
}
