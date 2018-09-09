/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

import lk.ijse.tpmgt.dao.CrudDAOImpl;
import lk.ijse.tpmgt.dao.CrudUtil;
import lk.ijse.tpmgt.dao.custom.SalaryDAO;
import lk.ijse.tpmgt.entity.Salary;


public class SalaryDAOImpl extends CrudDAOImpl<Salary , String> implements SalaryDAO {

//    @Override
//    public boolean save(Salary entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into salary values(?,?,?,?,?,?,?,?)",
//                entity.getsId(),
//                entity.getsDate(),
//                entity.getTotalKm(),
//                entity.getBonus(),
//                entity.getAmountPerKm(),
//                entity.getEarn(),
//                entity.getTotal(),
//                entity.getNic());
//    }
//
//    @Override
//    public boolean update(Salary entity) throws Exception {
//        return CrudUtil.executeUpdate("Update salary set sDate = ?, totalKm = ?, bonus = ?, amountPerKm = ?, earn = ?, total=?, nic=?  where sId = ?",
//                entity.getsDate(),
//                entity.getTotalKm(),
//                entity.getBonus(),
//                entity.getAmountPerKm(),
//                entity.getEarn(),
//                entity.getTotal(),
//                entity.getNic(),
//                entity.getsId());
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from salary where sId = ?", id);
//    }
//
//    @Override
//    public Salary find(String id) throws Exception {
//       ResultSet rst = CrudUtil.executeQuery("select * from salary where sId = ?", id);
//        if(rst.next()){
//      return new Salary(rst.getString(1),
//              rst.getDate(2),
//              rst.getBigDecimal(3),
//              rst.getBigDecimal(4),
//              rst.getBigDecimal(5),
//              rst.getBigDecimal(6),
//              rst.getBigDecimal(7),
//              rst.getString(8));
//
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Salary> getAll() throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from salary");
//        ArrayList<Salary> allSalaries= new ArrayList<>();
//        while(rst.next()){
//            Salary salary= new Salary(rst.getString(1),
//                    rst.getDate(2),
//                    rst.getBigDecimal(3),
//                    rst.getBigDecimal(4),
//                    rst.getBigDecimal(5),
//                    rst.getBigDecimal(6),
//                    rst.getBigDecimal(7),
//                    rst.getString(8));
//                    allSalaries.add(salary);
//        }
//        return allSalaries;
//    }
    
}
    

