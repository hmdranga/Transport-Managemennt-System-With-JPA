/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A C E R
 */
@Entity
public class ExpenceType {
    @Id
    private String exId;
    private String type;

    @OneToMany(mappedBy = "expenceType",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private
    List<ExpenceDetail> expenceDetails = new ArrayList<>();

    public ExpenceType() {
    }

    public ExpenceType(String exId, String type) {
        this.exId = exId;
        this.type = type;
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

    @Override
    public String toString() {
        return "ExpenceType{" + "exId=" + exId + ", type=" + type + '}';
    }


    public List<ExpenceDetail> getExpenceDetails() {
        return expenceDetails;
    }

    public void setExpenceDetails(List<ExpenceDetail> expenceDetails) {
        this.expenceDetails = expenceDetails;
    }
}
