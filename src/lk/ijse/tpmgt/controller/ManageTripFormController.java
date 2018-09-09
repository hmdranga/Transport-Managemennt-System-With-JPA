/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import lk.ijse.tpmgt.business.custom.DriverBO;
import lk.ijse.tpmgt.business.custom.TripBO;
import lk.ijse.tpmgt.business.custom.VehicleBO;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.dto.TripDetailDTO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.main.StartUp;
import lk.ijse.tpmgt.view.util.tblmodel.TripTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageTripFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXDatePicker txtTDate;
    @FXML
    private JFXTextField txtStart;
    @FXML
    private JFXTextField txtEnd;
    @FXML
    private JFXTextField txtTripID;
    @FXML
    private JFXComboBox<String> cmbNIC;
    @FXML
    private JFXComboBox<String> cmbVRegNo;
    @FXML
    private JFXButton btnAdd;
    
    private TripBO tripBO;
    
    private ArrayList<DriverDTO> driverDetailsList;
    
    private ArrayList<VehicleDTO> vehicleDetailList;
    
    @FXML
    private TableView<TripTM> tblTrip;
    
    private DriverBO driverBO;
    private VehicleBO vehicleBO;
    
    @FXML
    private JFXTextField txtName;
    
    public ManageTripFormController() {
    this.tripBO = (TripBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.TRIP);
    this.driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.DRIVER);
    this.vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.VEHICLE);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         tblTrip.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
         tblTrip.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
         tblTrip.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("start"));
         tblTrip.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("end"));
         tblTrip.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
         tblTrip.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("regNo")); 
         loadAllTrips();
         loadCmbNic();
         loadCmbRegNo();
    }    

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void cmbNICOnAction(ActionEvent event) {
       String nic = cmbNIC.getValue();
        for (DriverDTO driverDTO : driverDetailsList) {
            if(nic.equals(driverDTO.getNic())){
                txtName.setText(driverDTO.getName());
                break;
            }
        }
    }

    @FXML
    private void btnAddOnAction(ActionEvent event) {
        save();
    }
    
     private void loadCmbRegNo() {
        try {

            this.vehicleDetailList = vehicleBO.getAllVehicle();
            ArrayList<String> allIDS = new ArrayList<>();
            for (VehicleDTO vehicleDTO : vehicleDetailList) {
                allIDS.add(vehicleDTO.getRegNo());
            }
            cmbVRegNo.setItems(FXCollections.observableArrayList( allIDS));
        } catch (Exception ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadCmbNic() {
        try {

            this.driverDetailsList = driverBO.getAllDriver();
            ArrayList<String> allIDS = new ArrayList<>();
            for (DriverDTO driverDTO : driverDetailsList) {
                allIDS.add(driverDTO.getNic());
            }
            cmbNIC.setItems(FXCollections.observableArrayList( allIDS));
        } catch (Exception ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void save(){
        
    String id =txtTripID.getText();
    LocalDate date1 =txtTDate.getValue();
    Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(date1.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ManageTripFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BigDecimal start = new BigDecimal(txtStart.getText());
        BigDecimal end = new BigDecimal(txtEnd.getText());
        String regNo = cmbVRegNo.getValue();
        String nic = cmbNIC.getValue();
        TripDetailDTO tripDetailDTO= new TripDetailDTO(id, date, start, end, regNo, nic);
        try {
            boolean result = tripBO.saveTrip(tripDetailDTO);
            if (result) {
                new Alert(Alert.AlertType.CONFIRMATION, "Expence Detail Added Successfully", ButtonType.OK).show();
               loadAllTrips();
            } else {
                new Alert(Alert.AlertType.ERROR, "Faild to save Expence Detail", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadAllTrips() {
        
        try {
            ArrayList<TripDetailDTO> allTripDetails = tripBO.getAllTrip();
            ObservableList<TripTM> olTrips = tblTrip.getItems();
            olTrips.removeAll(olTrips);

            for (TripDetailDTO tripDetail : allTripDetails) {
                TripTM tripTM = new TripTM(tripDetail.getId(),
                        tripDetail.getDate(),
                        tripDetail.getStart(),
                        tripDetail.getEnd(),
                        tripDetail.getNic(),
                        tripDetail.getRegNo());
                        
                olTrips.add(tripTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}
