/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.handler.HandlerException;
import lk.ijse.tpmgt.business.BOFactory;
import lk.ijse.tpmgt.business.custom.ExpenceDetailBO;
import lk.ijse.tpmgt.business.custom.VehicleBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.SuperDAO;
import lk.ijse.tpmgt.dao.custom.ExpenceDetailDAO;

import lk.ijse.tpmgt.db.JpaUtil;
import lk.ijse.tpmgt.dto.ExpenceDetailDTO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.entity.ExpenceDetail;
import lk.ijse.tpmgt.entity.ExpenceDetail_PK;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class ExpenceDetailBOImpl implements ExpenceDetailBO {
    private ExpenceDetailDAO expenceDetailDAO;
    private EntityManagerFactory entityManagerFactory;

    public ExpenceDetailBOImpl() {
        this.expenceDetailDAO = (ExpenceDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.EXPENCEDETAIL);
        entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
    }
    
    @Override
    public boolean saveExpenceDetail(ExpenceDetailDTO expenceDetail) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            expenceDetailDAO.setEntityManager(entityManager);

            ExpenceDetail expenceDetail1 = new ExpenceDetail(expenceDetail.getRegNo(),expenceDetail.getExId(),expenceDetail.getDate(),expenceDetail.getAmount(),expenceDetail.getDescription());
            expenceDetailDAO.save(expenceDetail1);
        entityManager.getTransaction().commit();
        entityManager.close();
            return true;

//        return  expenceDetailDAO.save(new ExpenceDetail(expenceDetail.getRegNo(),
//                expenceDetail.getExId(),
//                expenceDetail.getDate(),
//                expenceDetail.getAmount(),
//                expenceDetail.getDescription()));
    }

//    @Override
//    public boolean updateExpenceDetail(ExpenceDetailDTO expenceDetail) throws Exception {
//        return expenceDetailDAO.update(new ExpenceDetail(expenceDetail.getRegNo(),
//                expenceDetail.getExId(),
//                expenceDetail.getDate(),
//                expenceDetail.getAmount(),
//                expenceDetail.getDescription()));
//
//    }

//delete not used in expencedetail ui
//    @Override
//    public boolean deleteExpenceDetail(ExpenceDetailDTO expenceDetailDTO) throws Exception {
//        try (Session session = sessionFactory.openSession()) {
//            expenceDetailDAO.setSession(session);
//            session.beginTransaction();
//
//
//
//            session.getTransaction().commit();
//            return true;
//        }catch (HandlerException exp){
//            return false;
//        }
//       // return expenceDetailDAO.delete(new ExpenceDetail_PK(expenceDetailDTO.getRegNo(), expenceDetailDTO.getExId()));
//    }

//    @Override
//    public ExpenceDetailDTO findByID(ExpenceDetailDTO expenceDetailDTO) throws Exception {
//      ExpenceDetail expenceDetail = expenceDetailDAO.find(new ExpenceDetail_PK(expenceDetailDTO.getRegNo(), expenceDetailDTO.getExId()));
//      ExpenceDetailDTO expenceDetailDTO1= new ExpenceDetailDTO(expenceDetail.getExpenceDetail_pk().getRegNo(),
//              expenceDetail.getExpenceDetail_pk().getExId(),
//              expenceDetail.getDate(),
//              expenceDetail.getAmount(),expenceDetail.getDescription());
//        return expenceDetailDTO1;
//    }

    @Override
    public ArrayList<ExpenceDetailDTO> getAllExpenceDetail() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

            expenceDetailDAO.setEntityManager(entityManager);

            List<ExpenceDetail> allExpenceDetails = expenceDetailDAO.getAll();

            ArrayList<ExpenceDetailDTO> dtos = new ArrayList<>();

            for(ExpenceDetail expenceDetail : allExpenceDetails){
                ExpenceDetailDTO expenceDetailDTO=new ExpenceDetailDTO(expenceDetail.getExpenceDetail_pk().getRegNo(),
                        expenceDetail.getExpenceDetail_pk().getExId(),
                        expenceDetail.getDate(),
                        expenceDetail.getAmount(),
                        expenceDetail.getDescription());
                dtos.add(expenceDetailDTO);
            }
        entityManager.getTransaction().commit();
        entityManager.close();
            return dtos;


//
//        List<ExpenceDetail> allExpenceDetails=expenceDetailDAO.getAll();
//        ArrayList<ExpenceDetailDTO> dtos = new ArrayList<>();
//        for (ExpenceDetail expenceDetail : allExpenceDetails) {
//            ExpenceDetailDTO expenceDetailDTO=new ExpenceDetailDTO(expenceDetail.getExpenceDetail_pk().getRegNo(),
//                    expenceDetail.getExpenceDetail_pk().getExId(),
//                    expenceDetail.getDate(),
//                    expenceDetail.getAmount(),
//                    expenceDetail.getDescription());
//            dtos.add(expenceDetailDTO);
//
//        }
//        return dtos;
//
    }

    @Override
    public ArrayList<VehicleDTO> getVehicleID() throws Exception {
        VehicleBO vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLE);
        return vehicleBO.getVehicleID();
    }
    
}



// try (Session session = sessionFactory.openSession()) {
//         expenceDetailDAO.setSession(session);
//         session.beginTransaction();
//
//
//         session.getTransaction().commit();
//         return true;
//         }catch (HandlerException exp){
//         return false;
//         }