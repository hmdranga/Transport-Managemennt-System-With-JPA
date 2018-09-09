/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business;

import lk.ijse.tpmgt.business.custom.impl.DriverBOImpl;
import lk.ijse.tpmgt.business.custom.impl.ExpenceDetailBOImpl;
import lk.ijse.tpmgt.business.custom.impl.ExpenceTypeBOImpl;
import lk.ijse.tpmgt.business.custom.impl.SalaryBOImpl;
import lk.ijse.tpmgt.business.custom.impl.TripBOImpl;
import lk.ijse.tpmgt.business.custom.impl.VehicleBOImpl;

/**
 *
 * @author A C E R
 */
public class BOFactory {
    private static BOFactory boFactory;

    private static BOFactory bOFactory;
    
    public enum BoTypes{
        DRIVER, EXPENCEDETAIL,EXPENCETYPE,SALARY,TRIP,VEHICLE;
    }
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null){
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BoTypes boType){
        switch(boType){
            case DRIVER:
                return new DriverBOImpl();
            case EXPENCEDETAIL:
                return new ExpenceDetailBOImpl();
            case EXPENCETYPE:
                return new ExpenceTypeBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case TRIP:
                return new TripBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            default:
                return null;
        }
    }
}
