package lk.ijse.tpmgt.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JpaUtil {

    private static JpaUtil jpaUtil;
    private EntityManagerFactory entityManagerFactory;

    private JpaUtil(){

        Properties jpaProperties = new Properties();


        try {
            File jpaPropFile = new File("application.properties");
            FileReader propReader = new FileReader(jpaPropFile);
            jpaProperties.load(propReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManagerFactory = Persistence.createEntityManagerFactory("boot",jpaProperties);
    }

    public static JpaUtil getInstance(){
        if (jpaUtil == null){
            jpaUtil = new JpaUtil();
        }q
        return jpaUtil;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
