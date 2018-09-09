/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.ExpenceTypeDTO;

/**
 *
 * @author A C E R
 */
public interface ExpenceTypeBO extends SuperBO {
    public boolean saveExpenceType(ExpenceTypeDTO expenceType)throws Exception;
    
//    public boolean updateExpenceType(ExpenceTypeDTO expenceType)throws Exception;
//
//    public boolean  deleteExpenceType(String id)throws Exception;
//
   public ExpenceTypeDTO findByID(String id)throws Exception;
    
//    public ArrayList<ExpenceTypeDTO> getAllExpenceType()throws Exception;
    
    public ArrayList<ExpenceTypeDTO> getExpenceTypeID() throws Exception;
}
