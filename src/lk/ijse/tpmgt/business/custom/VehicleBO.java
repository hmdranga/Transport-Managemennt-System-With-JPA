/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.VehicleDTO;

/**
 *
 * @author A C E R
 */
public interface VehicleBO extends SuperBO{
    public boolean saveVehicle(VehicleDTO vehicle)throws Exception;
    
    public boolean updateVehicle(VehicleDTO vehicle)throws Exception;
    
    public boolean  deleteVehicle(String id)throws Exception;
    
    //public VehicleDTO findByID(String id)throws Exception;
    
    public ArrayList<VehicleDTO> getAllVehicle()throws Exception;
    
   public ArrayList<VehicleDTO> getVehicleID() throws Exception;
    
    
}
