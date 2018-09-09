/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.ijse.tpmgt.dao.CrudDAOImpl;
import lk.ijse.tpmgt.dao.CrudUtil;
import lk.ijse.tpmgt.dao.custom.VehicleDAO;
import lk.ijse.tpmgt.entity.Vehicle;


public class VehicleDAOImpl extends CrudDAOImpl<Vehicle,String > implements VehicleDAO {

//    @Override
//    public boolean save(Vehicle entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into vehicle values(?,?,?,?)",
//                entity.getRegNo(),
//                entity.getBrand(),
//                entity.getColour(),
//                entity.getBoughtDate());
//    }
//
//    @Override
//    public boolean update(Vehicle entity) throws Exception {
//        return CrudUtil.executeUpdate("Update vehicle set brand = ?, colour = ?, boughtDate = ? where regNo = ?",
//                entity.getBrand(),
//                entity.getColour(),
//                entity.getBoughtDate(),
//                entity.getRegNo());
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from vehicle where regNo = ?", id);
//    }
//
//    @Override
//    public Vehicle find(String id) throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from vehicle where regNo = ?", id);
//        if(rst.next()){
//        return new Vehicle(rst.getString(1),
//                rst.getString(2),
//                rst.getString(3),
//                rst.getDate(4));
//
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Vehicle> getAll() throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from vehicle");
//        ArrayList<Vehicle> allVehicles= new ArrayList<>();
//        while(rst.next()){
//            Vehicle vehicle= new Vehicle(rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getDate(4));
//                    allVehicles.add(vehicle);
//
//        }
//        return allVehicles;
//    }
   
    
}
    

