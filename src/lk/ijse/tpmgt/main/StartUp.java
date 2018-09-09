/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.main;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.tpmgt.db.HibernateUtil;
import lk.ijse.tpmgt.entity.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author A C E R
 */
public class StartUp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/tpmgt/view/MainForm.fxml"));
            
            Scene mainScene = new Scene(root);

            primaryStage.setTitle("Transport Management System : DEP");
            primaryStage.setScene(mainScene);
            primaryStage.setResizable(false);
            
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void navigateToHome(Node node, Stage mainStage) {

    
            TranslateTransition tt = new TranslateTransition(Duration.millis(300), node);
            tt.setFromX(0);
            tt.setToX(-node.getScene().getWidth());
            tt.play();
            
            Platform.runLater(()->{
            
                try {
                    Parent root = FXMLLoader.load(StartUp.class.getResource("/lk/ijse/tpmgt/view/MainForm.fxml"));
                    Scene mainScene = new Scene(root);
                    mainStage.setScene(mainScene);
                    
                    TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
                    tt1.setToX(0);
                    tt1.setFromX(-mainScene.getWidth());
                    tt1.play();
                    
                    mainStage.centerOnScreen();
                } catch (IOException ex) {
                    Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);


//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        try (Session session = sessionFactory.openSession()) {
//
//            session.beginTransaction();
//
//            Driver driver = new Driver("945854357V","Suranga", "Galle","0755785778","B2287415");
//            //String nic, String name, String address, String contactNo, String drivingLicenceNo
//
////            Order order1 = new Order(new Date(), customer);
////            Order order2 = new Order(new Date(), customer);
////
////            customer.getOrders().add(order1);
////            customer.getOrders().add(order2);
//
//            session.persist(driver);
//
//            session.getTransaction().commit();
//
//        }
//
//        sessionFactory.close();

    }

    
}
