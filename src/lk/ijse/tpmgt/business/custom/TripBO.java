/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.TripDetailDTO;

/**
 *
 * @author A C E R
 */
public interface TripBO extends SuperBO{
    public boolean saveTrip(TripDetailDTO trip)throws Exception;
    
//    public boolean updateTrip(TripDetailDTO trip)throws Exception;
//
//    public boolean  deleteTrip(String id)throws Exception;
    
   // public TripDetailDTO findByID(String id)throws Exception;
    
    public ArrayList<TripDetailDTO> getAllTrip()throws Exception;
}
