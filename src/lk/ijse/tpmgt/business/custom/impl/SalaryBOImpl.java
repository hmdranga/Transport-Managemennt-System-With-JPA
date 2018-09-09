/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.business.custom.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.ijse.tpmgt.business.BOFactory;
import lk.ijse.tpmgt.business.custom.DriverBO;
import lk.ijse.tpmgt.business.custom.SalaryBO;
import lk.ijse.tpmgt.dao.DAOFactory;
import lk.ijse.tpmgt.dao.custom.DriverDAO;
import lk.ijse.tpmgt.dao.custom.QueryDAO;
import lk.ijse.tpmgt.dao.custom.SalaryDAO;
import lk.ijse.tpmgt.db.JpaUtil;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.dto.SalaryDTO;
import lk.ijse.tpmgt.entity.Driver;
import lk.ijse.tpmgt.entity.Salary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class SalaryBOImpl implements SalaryBO {
    private DriverDAO driverDAO;
    private SalaryDAO salaryDAO;
    private QueryDAO queryDAO;
    private EntityManagerFactory entityManagerFactory;

    public SalaryBOImpl() {
        this.salaryDAO = (SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.SALARY);
        this.queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.QUERY);
        driverDAO = (DriverDAO) DAOFactory.getInstance().getDAO(DAOFactory.DaoTypes.DRIVER);
        entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
    }
    
    

    @Override
    public boolean saveSalary(SalaryDTO salary) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        queryDAO.setEntityManager(entityManager);
        Date d= new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String curdate=df.format(d);
        String startDate=df.format(salary.getsDate());
        BigDecimal totalKm=queryDAO.getTotalDistanceForDriver(startDate, curdate,salary.getNic());
        BigDecimal earn = totalKm.multiply(salary.getAmountPerKm());
        BigDecimal total= earn.add(salary.getBonus());


            salaryDAO.setEntityManager(entityManager);
            driverDAO.setEntityManager(entityManager);

            Driver driver =  driverDAO.find(salary.getNic());
            Salary salary1 = new Salary(salary.getsId(), df.parse(curdate), totalKm, salary.getBonus(), salary.getAmountPerKm() , earn, total, driver);
           salaryDAO.save(salary1);
        entityManager.getTransaction().commit();
        entityManager.close();
            return true;

    }



    @Override
    public ArrayList<SalaryDTO> getAllSalary() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

            salaryDAO.setEntityManager(entityManager);

            List<Salary> allSalarys = salaryDAO.getAll();

            ArrayList<SalaryDTO> salaryDTOs = new ArrayList<>();

            for(Salary salary : allSalarys){
                SalaryDTO salaryDTO = new SalaryDTO(salary.getsId(),
                        salary.getsDate(),
                        salary.getTotalKm(),
                        salary.getBonus(),
                        salary.getAmountPerKm(),
                        salary.getEarn(),
                        salary.getTotal(),salary.getDriver().getNic());
                salaryDTOs.add(salaryDTO);
            }
        entityManager.getTransaction().commit();
        entityManager.close();
            return salaryDTOs;


    }

    @Override
    public ArrayList<DriverDTO> getDriverID() throws Exception {

        DriverBO driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.DRIVER);
        return driverBO.getDriverID();

    }
    
}
