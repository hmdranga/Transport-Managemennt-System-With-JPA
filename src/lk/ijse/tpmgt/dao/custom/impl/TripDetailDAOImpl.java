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
import lk.ijse.tpmgt.dao.custom.TripDetailDAO;
import lk.ijse.tpmgt.entity.TripDetail;


public class TripDetailDAOImpl extends CrudDAOImpl<TripDetail,String> implements TripDetailDAO {

//    @Override
//    public boolean save(TripDetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into tripdetail values(?,?,?,?,?,?)",
//                entity.getId(),
//                entity.getDate(),
//                entity.getStart(),
//                entity.getEnd(),
//                entity.getRegNo(),
//                entity.getNic()
//                );
//    }
//
//    @Override
//    public boolean update(TripDetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Update tripdetail set date = ?, start = ?, end = ?, regNo = ?, nic = ? where id = ?",
//                entity.getDate(),
//                entity.getStart(),
//                entity.getEnd(),
//                entity.getRegNo(),
//                entity.getNic(),
//                entity.getId());
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return  CrudUtil.executeUpdate("Delete from tripdetail where id = ?", id);
//    }
//
//    @Override
//    public TripDetail find(String id) throws Exception {
//        ResultSet rst = CrudUtil.executeQuery("select * from tripdetail where id = ?", id);
//        if(rst.next()){
//        return new TripDetail(rst.getString(1),
//                rst.getDate(2),
//                rst.getBigDecimal(3),
//                rst.getBigDecimal(4),
//                rst.getString(5),
//                rst.getString(6));
//
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<TripDetail> getAll() throws Exception {
//         ResultSet rst = CrudUtil.executeQuery("select * from tripdetail");
//        ArrayList<TripDetail> allTripDetails= new ArrayList<>();
//        while(rst.next()){
//            TripDetail tripDetail= new TripDetail(rst.getString(1),
//                    rst.getDate(2),
//                    rst.getBigDecimal(3),
//                    rst.getBigDecimal(4),
//                    rst.getString(5),
//                    rst.getString(6));
//                    allTripDetails.add(tripDetail);
//
//        }
//        return allTripDetails;
//    }
}
    

