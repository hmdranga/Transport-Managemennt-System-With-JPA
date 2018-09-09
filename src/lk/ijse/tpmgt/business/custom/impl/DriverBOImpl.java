/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.handler.HandlerException;
import lk.ijse.tpmgt.business.custom.DriverBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.DriverDAO;

import lk.ijse.tpmgt.db.JpaUtil;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.entity.Driver;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class DriverBOImpl implements DriverBO {
    private DriverDAO driverDAO;
    private EntityManagerFactory entityManagerFactory;

    public DriverBOImpl() {

        this.driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.DRIVER);
        entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
    }
    
    

    @Override
    public boolean saveDriver(DriverDTO driver) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            driverDAO.setEntityManager(entityManager);

            Driver driver1 = new Driver(driver.getNic(),driver.getName(),driver.getAddress(),driver.getContactNo(),driver.getDrivingLicenceNo());
            driverDAO.save(driver1);
        entityManager.getTransaction().commit();
        entityManager.close();
            return true;


    }


    @Override
    public boolean updateDriver(DriverDTO driver) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            driverDAO.setEntityManager(entityManager);
            Driver driver1= driverDAO.find(driver.getNic());
            driver1.setAddress(driver.getAddress());
            driver1.setName(driver.getName());
            driver1.setContactNo(driver.getContactNo());
            driver1.setDrivingLicenceNo(driver.getDrivingLicenceNo());
//            Driver driver1 = new Driver(driver.getNic(),driver.getName(),driver.getAddress(),driver.getContactNo(),driver.getDrivingLicenceNo());
            driverDAO.update(driver1);
        entityManager.getTransaction().commit();
        entityManager.close();
            return  true;


//        return driverDAO.update(new  Driver(driver.getNic(),
//                driver.getName(),
//                driver.getAddress(),
//                driver.getContactNo(),
//                driver.getDrivingLicenceNo()));
    }
//
    @Override
    public boolean deleteDriver(String id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            driverDAO.setEntityManager(entityManager);
            driverDAO.delete(id);
        entityManager.getTransaction().commit();
        entityManager.close();
            return true;

        //return driverDAO.delete(id);
    }
//
//    @Override
//    public DriverDTO findByID(String id) throws Exception {
//        Driver driver= driverDAO.find(id);
//        DriverDTO driverDTO= new DriverDTO(driver.getNic(),
//                driver.getName(),
//                driver.getAddress(),
//                driver.getContactNo(),
//                driver.getDrivingLicenceNo());
//
//        return driverDTO;
//    }
//
    @Override
    public ArrayList<DriverDTO> getAllDriver() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            driverDAO.setEntityManager(entityManager);

            List<Driver> allDrivers = driverDAO.getAll();
            ArrayList<DriverDTO> dtos = new ArrayList<>();

            for(Driver driver : allDrivers){
                DriverDTO driverDTO = new DriverDTO(driver.getNic(),driver.getName(),driver.getAddress(),driver.getContactNo(),driver.getDrivingLicenceNo());
                dtos.add(driverDTO);
            }
        entityManager.getTransaction().commit();
        entityManager.close();
            return dtos;


//        ArrayList<Driver> allDrivers= driverDAO.getAll();
//            ArrayList<DriverDTO> dtos= new ArrayList<>();
//
//            for(Driver driver : allDrivers){
//                DriverDTO driverDTO= new DriverDTO(driver.getNic(), driver.getName(), driver.getAddress(), driver.getContactNo(), driver.getDrivingLicenceNo());
//                dtos.add(driverDTO);
//            }
//            return dtos;
    }
    @Override
    public ArrayList<DriverDTO> getDriverID() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            driverDAO.setEntityManager(entityManager);

            List<Driver> allDrivers = driverDAO.getAll();
            ArrayList<DriverDTO> ids = new ArrayList<>();
            for (Driver driver : allDrivers) {
             String nic = driver.getNic();
            DriverDTO driverDTO= new DriverDTO(nic);
            ids.add(driverDTO);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
            return ids;


//        ArrayList<Driver> allDrivers = driverDAO.getAll();
//          ArrayList<DriverDTO> ids = new ArrayList<>();
//           for (Driver driver : allDrivers) {
//             String nic = driver.getNic();
//            DriverDTO driverDTO= new DriverDTO(nic);
//            ids.add(driverDTO);
//        }
//           return ids;
    }

}
