/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.tpmgt.business.SuperBO;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.dto.SalaryDTO;

/**
 *
 * @author A C E R
 */
public interface SalaryBO extends SuperBO{
    public boolean saveSalary(SalaryDTO salary)throws Exception;
    
//    public boolean updateSalary(SalaryDTO salary)throws Exception;
//
//    public boolean  deleteSalary(String id)throws Exception;
    
  //  public SalaryDTO findByID(String id)throws Exception;
    
    public ArrayList<SalaryDTO> getAllSalary()throws Exception;
    
    public ArrayList<DriverDTO> getDriverID() throws Exception;
}
