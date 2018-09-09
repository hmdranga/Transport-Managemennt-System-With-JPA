/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao.custom;

import java.math.BigDecimal;
import lk.ijse.tpmgt.dao.SuperDAO;

/**
 *
 * @author A C E R
 */
public interface QueryDAO extends SuperDAO{
    
    public BigDecimal getTotalDistanceForDriver(String startDate, String curdate, String nic) throws Exception;
}
