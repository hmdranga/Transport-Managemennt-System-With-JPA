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

public class TripTM {
    private String id;
    private Date date;
    private BigDecimal start;
    private BigDecimal end;
    private String nic;
    private String regNo;

    public TripTM() {
    }

    public TripTM(String id, Date date, BigDecimal start, BigDecimal end, String nic, String regNo) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.nic = nic;
        this.regNo = regNo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the start
     */
    public BigDecimal getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(BigDecimal start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public BigDecimal getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(BigDecimal end) {
        this.end = end;
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

   

    
}
