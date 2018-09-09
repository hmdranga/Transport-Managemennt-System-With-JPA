/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;

/**
 *
 * @author A C E R
 */
public interface SuperDAO{
    void setEntityManager(EntityManager entityManager);

    
}
