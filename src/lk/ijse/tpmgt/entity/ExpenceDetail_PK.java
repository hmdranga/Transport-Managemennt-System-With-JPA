/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author A C E R
 */
@Embeddable
public class ExpenceDetail_PK implements Serializable {
    private String regNo;
    private String exId;

    public ExpenceDetail_PK() {
    }

    public ExpenceDetail_PK(String regNo, String exId) {
        this.regNo = regNo;
        this.exId = exId;
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

    @Override
    public String toString() {
        return "ExpenceDetail_PK{" + "regNo=" + regNo + ", exId=" + exId + '}';
    }

    
}
