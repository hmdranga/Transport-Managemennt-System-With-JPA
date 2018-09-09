/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import static com.lowagie.text.xml.simpleparser.EntitiesToSymbol.map;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.tpmgt.business.BOFactory;
import lk.ijse.tpmgt.business.custom.VehicleBO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.main.StartUp;
import lk.ijse.tpmgt.view.util.tblmodel.VehicleTM;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import sun.util.calendar.BaseCalendar;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageVehicleFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtRegNo;
    @FXML
    private JFXTextField txtColour;
    @FXML
    private JFXTextField txtBrand;
    @FXML
    private TableView<VehicleTM> tblVehicle;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnAddNew;
    
    private VehicleBO vehicleBO;
    @FXML
    private JFXDatePicker txtBoughtDate;
    
    private boolean decide = false;
    @FXML
    private JFXButton btnReport;

    public ManageVehicleFormController() {
        this.vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLE);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("regNo"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("colour"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("boughtDate"));
        loadAllVehicles();
    }    

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        String regno = txtRegNo.getText();
        
        if (!regno.matches("^[a-zA-Z]{2}\\-[0-9]{4}$")/*|| !regno.matches("^[a-zA-Z]{3}[0-9]{4}$")*/){
            new Alert(Alert.AlertType.ERROR,"Invalid Vehicle Registration Number!",ButtonType.OK).show();
            txtRegNo.requestFocus();
            return;
           }
        
         if(decide){
            save();
        }else if(tblVehicle.getSelectionModel().getSelectedIndex()>=0&& decide ==false ){
           update();  
        }
        else{
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Vehicle..", ButtonType.OK).show();
        }
        
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        if(tblVehicle.getSelectionModel().getSelectedIndex()>=0){
        delete();
        loadAllVehicles();
        }else{
        new Alert(Alert.AlertType.INFORMATION, "Select a Vehicle to Delete", ButtonType.OK).show();
        }
    }


    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
        decide = true;
        clearFields();
        tblVehicle.getSelectionModel().clearSelection();
    }
    

     private void loadAllVehicles() {
        
        try {
            ArrayList<VehicleDTO> allVehicles = vehicleBO.getAllVehicle();
            ObservableList<VehicleTM> olVehicles = tblVehicle.getItems();
            olVehicles.removeAll(olVehicles);

            for (VehicleDTO vehicle : allVehicles) {
                VehicleTM vehicleTM = new VehicleTM(vehicle.getRegNo(),
                        vehicle.getBrand(),
                        vehicle.getColour(),
                        vehicle.getBoughtDate());
                        
                olVehicles.add(vehicleTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
    //    private String regNo;
//    private String brand;
//    private String colour;
//    private Date boughtDate;
      private void update(){
        try {
            VehicleTM vehicleTM = tblVehicle.getSelectionModel().getSelectedItem();
            String vehicle = vehicleTM.getRegNo();
            String vehicleBrand = txtBrand.getText();
            String vehicleColour = txtColour.getText();
            LocalDate vehicleBoughtDate = txtBoughtDate.getValue();
            Date date = new Date();
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleBoughtDate.toString());
            } catch (ParseException ex) {
                Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle, vehicleBrand, vehicleColour, date);
            
            
            boolean result = vehicleBO.updateVehicle(vehicleDTO);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Updated Successfully",ButtonType.OK).show();
                clearFields();
                loadAllVehicles();
            }else{
                new Alert(Alert.AlertType.ERROR, "Faild to Update Vehicle", ButtonType.OK).show();
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
    private void save() {
        
        try {
            
            String vehicle = txtRegNo.getText();
            String vehicleBrand = txtBrand.getText();
            String vehicleColour = txtColour.getText();
            LocalDate vehicleBoughtDate = txtBoughtDate.getValue();
            Date date = new Date();
            
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(vehicleBoughtDate.toString());
            } catch (ParseException ex) {
                Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            VehicleDTO vehicleDTO = new VehicleDTO(vehicle, vehicleBrand, vehicleColour, date);
            
            boolean result = vehicleBO.saveVehicle(vehicleDTO);
            if (result) {
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Save Successfully", ButtonType.OK).show();
                clearFields();
                loadAllVehicles();
            } else {
                new Alert(Alert.AlertType.ERROR, "Faild to save Vehicle", ButtonType.OK).show();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
    private void delete(){
        try {
            VehicleTM vehicle=tblVehicle.getSelectionModel().getSelectedItem();
            String id = vehicle.getRegNo();
            
            boolean result = vehicleBO.deleteVehicle(id);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Vehicle deleted successfully..", ButtonType.OK).show();
                
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error when deleting Driver..", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void clearFields() {
        txtRegNo.setText("");
        txtBrand.setText("");
        txtColour.setText("");
        txtBoughtDate.setValue(null);
        
    }

    @FXML
    private void btnReportOnAction(ActionEvent event)  {
//        try {
////            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//////            Session session = sessionFactory.openSession();
////            InputStream stm = getClass().getResourceAsStream("lk/ijse/tpmgt/Report/Vehicle.jasper");
////            JasperPrint jasp = JasperFillManager.fillReport(stm, map,sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection());
////            JasperViewer.viewReport(jasp,false);
////        } catch (Exception ex) {
////            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
////        }
    }

    @FXML
    private void tblVehicleOnAction(MouseEvent event) {
        txtRegNo.setText(tblVehicle.getSelectionModel().getSelectedItem().getRegNo());
        txtBrand.setText(tblVehicle.getSelectionModel().getSelectedItem().getBrand());
        txtColour.setText(tblVehicle.getSelectionModel().getSelectedItem().getColour());
        //Date from1 = Date.from(tblVehicle.getSelectionModel().getSelectedItem().getBoughtDate());
        //  LocalDate date2 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //txtBoughtDate.setValue(from1);
        Date boughtDate = tblVehicle.getSelectionModel().getSelectedItem().getBoughtDate();
        LocalDate localDate = Instant.ofEpochMilli(boughtDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        txtBoughtDate.setValue(localDate);
       
    }
    
}
