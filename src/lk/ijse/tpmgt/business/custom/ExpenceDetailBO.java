/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.ExpenceDetailDTO;
import lk.ijse.tpmgt.dto.VehicleDTO;

/**
 *
 * @author A C E R
 */
public interface ExpenceDetailBO extends SuperBO{
    public boolean saveExpenceDetail(ExpenceDetailDTO expenceDetail)throws Exception;
    
    //public boolean updateExpenceDetail(ExpenceDetailDTO expenceDetail)throws Exception;
    
    //public boolean  deleteExpenceDetail(ExpenceDetailDTO expenceDetailDTO)throws Exception;
    
   // public ExpenceDetailDTO findByID(ExpenceDetailDTO expenceDetailDTO)throws Exception;
    
    public ArrayList<ExpenceDetailDTO> getAllExpenceDetail()throws Exception;
    
    public ArrayList<VehicleDTO> getVehicleID() throws Exception;
    

}
