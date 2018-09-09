/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dto;

import java.math.BigDecimal;

/**
 *
 * @author A C E R
 */
public class ExpenceTypeDTO {
    private String exId;
    private String type;

    public ExpenceTypeDTO() {
    }

    public ExpenceTypeDTO(String exId) {
        this.exId = exId;
    }

    public ExpenceTypeDTO(String exId, String type) {
        this.exId = exId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ExpenceTypeDTO{" + "exId=" + getExId() + ", type=" + getType() + '}';
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

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

   


}
