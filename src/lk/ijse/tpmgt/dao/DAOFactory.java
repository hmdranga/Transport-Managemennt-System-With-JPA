/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao;

import lk.ijse.tpmgt.dao.custom.impl.DriverDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.ExpenceDetailDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.ExpenceTypeDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.QueryDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.TripDetailDAOImpl;
import lk.ijse.tpmgt.dao.custom.impl.VehicleDAOImpl;

/**
 *
 * @author A C E R
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    
    public enum DaoTypes{
        DRIVER,EXPENCEDETAIL,EXPENCETYPE,QUERY,SALARY,TRIPDETAIL,VEHICLE;
    }
    
    private DAOFactory(){ 
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DaoTypes daoType){
        switch(daoType){
            case DRIVER:
                return new DriverDAOImpl();
            case EXPENCEDETAIL:
                return new ExpenceDetailDAOImpl();
            case EXPENCETYPE:
                return new ExpenceTypeDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case TRIPDETAIL:
                return new TripDetailDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            default:
                return null;
        }
    }
}
