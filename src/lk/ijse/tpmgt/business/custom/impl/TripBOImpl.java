/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.tpmgt.business.custom.TripBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.DriverDAO;
import lk.ijse.tpmgt.dao.custom.TripDetailDAO;
import lk.ijse.tpmgt.dao.custom.VehicleDAO;

import lk.ijse.tpmgt.db.JpaUtil;
import lk.ijse.tpmgt.dto.TripDetailDTO;
import lk.ijse.tpmgt.entity.Driver;
import lk.ijse.tpmgt.entity.TripDetail;
import lk.ijse.tpmgt.entity.Vehicle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class TripBOImpl implements TripBO {
    private VehicleDAO vehicleDAO;
    private DriverDAO driverDAO;
    private TripDetailDAO tripDetailDAO;
    private EntityManagerFactory entityManagerFactory;

    public TripBOImpl() {
        this.tripDetailDAO = (TripDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.TRIPDETAIL);
        vehicleDAO = (VehicleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.VEHICLE);
        driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.DRIVER);
        entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
    }
    
    

    @Override
    public boolean saveTrip(TripDetailDTO trip) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            tripDetailDAO.setEntityManager(entityManager);
            vehicleDAO.setEntityManager(entityManager);
            driverDAO.setEntityManager(entityManager);

            Vehicle vehicle = vehicleDAO.find(trip.getRegNo());
            Driver driver = driverDAO.find(trip.getNic());

            TripDetail tripDetail = new TripDetail(trip.getId(),trip.getDate(),trip.getStart(),trip.getEnd(),vehicle,driver);
            tripDetailDAO.save(tripDetail);
        entityManager.getTransaction().commit();;
        entityManager.close();
            return true;



//        return tripDetailDAO.save(new TripDetail(trip.getId(),
//                trip.getDate(),
//                trip.getStart(),
//                trip.getEnd(),
//                trip.getRegNo(),
//                trip.getNic()));
    }

//    @Override
//    public boolean updateTrip(TripDetailDTO trip) throws Exception {
//        return tripDetailDAO.update(new TripDetail(trip.getId(),
//                trip.getDate(),
//                trip.getStart(),
//                trip.getEnd(),
//                trip.getRegNo(),
//                trip.getNic()));
//    }
//
//    @Override
//    public boolean deleteTrip(String id) throws Exception {
//        return tripDetailDAO.delete(id);
//    }
//
//    @Override
//    public TripDetailDTO findByID(String id) throws Exception {
//        TripDetail trip = tripDetailDAO.find(id);
//        TripDetailDTO tripDetailDTO=new TripDetailDTO(trip.getId(),
//                trip.getDate(),
//                trip.getStart(),
//                trip.getEnd(),
//                trip.getRegNo(),
//                trip.getNic());
//        return tripDetailDTO;
//    }

    @Override
    public ArrayList<TripDetailDTO> getAllTrip() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            tripDetailDAO.setEntityManager(entityManager);


            List<TripDetail> allTripDetails = tripDetailDAO.getAll();

        entityManager.getTransaction().commit();;
        entityManager.close();

            ArrayList<TripDetailDTO> tripDetailDTOs = new ArrayList<>();

            for (TripDetail tripDetail : allTripDetails) {
            TripDetailDTO tripDetailDTO=new TripDetailDTO(tripDetail.getId(),
                    tripDetail.getDate(),
                    tripDetail.getStart(),
                    tripDetail.getEnd(),
                    tripDetail.getVehicle().getRegNo(),//getRegNo(),
                    tripDetail.getDriver().getNic());
            tripDetailDTOs.add(tripDetailDTO);
        }
        return tripDetailDTOs;


//        ArrayList<TripDetail> allTripDetails=tripDetailDAO.getAll();
//        ArrayList<TripDetailDTO> tripDetailDTOs=new ArrayList<>();
//        for (TripDetail tripDetail : allTripDetails) {
//            TripDetailDTO tripDetailDTO=new TripDetailDTO(tripDetail.getId(),
//                    tripDetail.getDate(),
//                    tripDetail.getStart(),
//                    tripDetail.getEnd(),
//                    tripDetail.getRegNo(),
//                    tripDetail.getNic());
//            tripDetailDTOs.add(tripDetailDTO);
//        }
//        return tripDetailDTOs;
    }
    
}
