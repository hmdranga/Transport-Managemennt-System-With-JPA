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
import lk.ijse.tpmgt.dao.custom.ExpenceTypeDAO;
import lk.ijse.tpmgt.entity.ExpenceType;


public class ExpenceTypeDAOImpl extends CrudDAOImpl<ExpenceType, String> implements ExpenceTypeDAO {

//    @Override
//    public boolean save(ExpenceType entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into expencetype values(?,?)",entity.getExId(),entity.getType());
//    }
//
//    @Override
//    public boolean update(ExpenceType entity) throws Exception {
//        return CrudUtil.executeUpdate("Update expencetype set type = ? where exId = ?",entity.getType(),entity.getExId());
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from expencetype where exId = ?", id);
//    }
//
//    @Override
//    public ExpenceType find(String id) throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from expencetype where exId = ?", id);
//        if(rst.next()){
//        return new ExpenceType(rst.getString(1),
//                rst.getString(2));
//
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<ExpenceType> getAll() throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from expencetype");
//        ArrayList<ExpenceType> allExpenceTypes= new ArrayList<>();
//        while(rst.next()){
//            ExpenceType expenceType= new ExpenceType(rst.getString(1),
//                    rst.getString(2));
//                    allExpenceTypes.add(expenceType);
//
//        }
//        return allExpenceTypes;
//    }
}
   
