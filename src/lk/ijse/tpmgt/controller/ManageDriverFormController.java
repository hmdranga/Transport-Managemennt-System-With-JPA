/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.tpmgt.business.BOFactory;
import lk.ijse.tpmgt.business.custom.DriverBO;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.main.StartUp;
import lk.ijse.tpmgt.view.util.tblmodel.DriverTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageDriverFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtContactNo;
    @FXML
    private JFXTextField txtDrivingLicenceNo;
    @FXML
    private TableView<DriverTM> tblDriver;
    @FXML
    private JFXButton btnAddNew;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;

    private DriverBO driverBO;
    
    private boolean decide = false;

    public ManageDriverFormController() {
        this.driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.DRIVER);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblDriver.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblDriver.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDriver.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblDriver.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        tblDriver.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("drivingLicenceNo"));
        loadAllDrivers();   
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
        decide = true;
        clearFields();
        tblDriver.getSelectionModel().clearSelection();
    }

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
         String nic = txtNic.getText();
        String name = txtName.getText();
        String conNo = txtContactNo.getText();
        String drivingLicence = txtDrivingLicenceNo.getText();
        
        
        if (!nic.matches("^\\d{9}[Vv]$")){
            new Alert(Alert.AlertType.ERROR,"Invalid NIC!",ButtonType.OK).show();
            txtNic.requestFocus();
            return;
           }
        
        if (!name.matches("[A-Za-z. ]+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Name!",ButtonType.OK).show();
            txtName.requestFocus();
            return;
           }
        if (!conNo.matches("^\\d{3}-\\d{7}$")){
            new Alert(Alert.AlertType.ERROR,"Invalid Contact Number!",ButtonType.OK).show();
            txtContactNo.requestFocus();
            return;
           }
        if (!drivingLicence.matches("^[Bb]\\d{7}$")){
            new Alert(Alert.AlertType.ERROR,"Invalid Driving Licence Number!",ButtonType.OK).show();
            txtDrivingLicenceNo.requestFocus();
            return;
           }
       
        if(decide){
            save();
        }else if(tblDriver.getSelectionModel().getSelectedIndex()>=0 && decide ==false){
           update();  
        }
        else{
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Driver..", ButtonType.OK).show();
        }
    }
  

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        if(tblDriver.getSelectionModel().getSelectedIndex()>=0){
            delete();
            loadAllDrivers();
        }else{
            new Alert(Alert.AlertType.ERROR, "Please select a customer to delete..", ButtonType.OK).show();
        }
        

    }

    private void loadAllDrivers() {
        try {
            ArrayList<DriverDTO> allDrivers = driverBO.getAllDriver();
            ObservableList<DriverTM> olDrivers = tblDriver.getItems();
            olDrivers.removeAll(olDrivers);

            for (DriverDTO driver : allDrivers) {
                DriverTM driverTM = new DriverTM(driver.getNic(),
                        driver.getName(),
                        driver.getAddress(),
                        driver.getContactNo(),
                        driver.getDrivingLicenceNo());
                olDrivers.add(driverTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      private void update(){
        DriverTM drivertbl = tblDriver.getSelectionModel().getSelectedItem();
        
        String driver = drivertbl.getNic();
        String driverName = txtName.getText();
        String driverAddress = txtAddress.getText();
        String driverConNum = txtContactNo.getText();
        String driverLicenceNo = txtDrivingLicenceNo.getText();
        DriverDTO driverDTO = new DriverDTO(driver, driverName, driverAddress, driverConNum, driverLicenceNo);
        
        try {
            boolean result = driverBO.updateDriver(driverDTO);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Driver Updated Successfully",ButtonType.OK).show();
                clearFields();
                loadAllDrivers();
            }else{
                new Alert(Alert.AlertType.ERROR, "Faild to Update Driver", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void save() {
        String driver = txtNic.getText();
        String driverName = txtName.getText();
        String driverAddress = txtAddress.getText();
        String driverConNum = txtContactNo.getText();
        String driverLicenceNo = txtDrivingLicenceNo.getText();

        DriverDTO driverDTO = new DriverDTO(driver, driverName, driverAddress, driverConNum, driverLicenceNo);
        try {
            boolean result = driverBO.saveDriver(driverDTO);
            if (result) {
                new Alert(Alert.AlertType.CONFIRMATION, "Driver Save Successfully", ButtonType.OK).show();
                clearFields();
                loadAllDrivers();
            } else {
                new Alert(Alert.AlertType.ERROR, "Faild to save Driver", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delete(){
         DriverTM driver=tblDriver.getSelectionModel().getSelectedItem();
         String id = driver.getNic();
        try {
            boolean result = driverBO.deleteDriver(id);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Driver deleted successfully..", ButtonType.OK).show();
                
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Error when deleting Driver..", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearFields() {
        txtNic.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContactNo.setText("");
        txtDrivingLicenceNo.setText("");
    }


    @FXML
    private void tblDriverOnAction(MouseEvent event) {
        txtNic.setText(tblDriver.getSelectionModel().getSelectedItem().getNic());
        txtName.setText(tblDriver.getSelectionModel().getSelectedItem().getName());
        txtAddress.setText(tblDriver.getSelectionModel().getSelectedItem().getAddress());
        txtContactNo.setText(tblDriver.getSelectionModel().getSelectedItem().getContactNo());
        txtDrivingLicenceNo.setText(tblDriver.getSelectionModel().getSelectedItem().getDrivingLicenceNo());
    }
    
  
}
