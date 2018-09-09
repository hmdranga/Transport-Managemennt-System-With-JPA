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
import lk.ijse.tpmgt.dao.custom.ExpenceDetailDAO;
import lk.ijse.tpmgt.entity.Driver;
import lk.ijse.tpmgt.entity.ExpenceDetail;
import lk.ijse.tpmgt.entity.ExpenceDetail_PK;


public class ExpenceDetailDAOImpl extends CrudDAOImpl<ExpenceDetail , ExpenceDetail_PK> implements ExpenceDetailDAO {

//    @Override
//    public boolean save(ExpenceDetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into expencedetail values(?,?,?,?,?)",
//                entity.getExpenceDetail_pk().getRegNo(),
//                entity.getExpenceDetail_pk().getExId(),
//                entity.getDate(),entity.getAmount(),
//                entity.getDescription());
//    }
//
//    @Override
//    public boolean update(ExpenceDetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Update expencedetail set date = ?, amount = ?, description = ? where regNo = ? and exId=?",
//                entity.getDate(),
//                entity.getAmount(),
//                entity.getDescription(),
//                entity.getExpenceDetail_pk().getRegNo(),
//                entity.getExpenceDetail_pk().getExId());
//    }
//
//    @Override
//    public boolean delete(ExpenceDetail_PK id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from expencedetail where regNo = ? and exId = ?", id.getRegNo(),id.getExId());
//    }
//
//    @Override
//    public ExpenceDetail find(ExpenceDetail_PK id) throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from expencedetail where  regNo = ? and exId = ?",
//                id.getRegNo(),
//                id.getExId());
//        if(rst.next()){
//        return new ExpenceDetail(rst.getString(1),
//                rst.getString(2),
//                rst.getDate(3),
//                rst.getBigDecimal(4),
//                rst.getString(5));
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<ExpenceDetail> getAll() throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from expencedetail");
//        ArrayList<ExpenceDetail> allExpenceDetails= new ArrayList<>();
//        while(rst.next()){
//            ExpenceDetail expenceDetail= new ExpenceDetail(rst.getString(1),
//                    rst.getString(2),
//                    rst.getDate(3),
//                    rst.getBigDecimal(4),
//                    rst.getString(5));
//                    allExpenceDetails.add(expenceDetail);
//
//
//        }
//        return allExpenceDetails;
//    }
}
    

