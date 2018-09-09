/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.DriverDTO;

/**
 *
 * @author A C E R
 */
public interface DriverBO extends SuperBO{
    public boolean saveDriver(DriverDTO driver)throws Exception;
    
    public boolean updateDriver(DriverDTO driver)throws Exception;
    
    public boolean  deleteDriver(String id)throws Exception;
    
   // public DriverDTO findByID(String id)throws Exception;
    
    public ArrayList<DriverDTO> getAllDriver()throws Exception;
    
    public ArrayList<DriverDTO> getDriverID() throws Exception;
}
