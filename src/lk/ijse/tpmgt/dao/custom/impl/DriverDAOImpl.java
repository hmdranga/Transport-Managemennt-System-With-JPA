/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.ijse.tpmgt.dao.CrudDAO;
import lk.ijse.tpmgt.dao.CrudDAOImpl;
import lk.ijse.tpmgt.dao.CrudUtil;
import lk.ijse.tpmgt.dao.custom.DriverDAO;
import lk.ijse.tpmgt.entity.Driver;


public class DriverDAOImpl extends CrudDAOImpl<Driver ,String> implements DriverDAO {

//    @Override
//    public boolean save(Driver entity) throws Exception {
//      return CrudUtil.executeUpdate("Insert into driver values(?,?,?,?,?)", entity.getNic(), entity.getName(),entity.getAddress(),entity.getContactNo(),entity.getDrivingLicenceNo());
//    }
//
//    @Override
//    public boolean update(Driver entity) throws Exception {
//        return CrudUtil.executeUpdate("Update driver set name = ?, address = ?, contactNo = ?, drivingLicenceNo = ? where nic = ?",entity.getName(),entity.getAddress(),entity.getContactNo(),entity.getDrivingLicenceNo(),entity.getNic());
//
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from driver where nic = ?", id);
//    }
//
//    @Override
//    public Driver find(String id) throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from driver where nic = ?", id);
//        if(rst.next()){
//        return new Driver(rst.getString(1),
//                rst.getString(2),
//                rst.getString(3),
//                rst.getString(4),
//                rst.getString(5));
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Driver> getAll() throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from driver");
//        ArrayList<Driver> allDrivers= new ArrayList<>();
//        while(rst.next()){
//            Driver driver= new Driver(rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5));
//                    allDrivers.add(driver);
//
//        }
//        return allDrivers;
//    }
    
}
