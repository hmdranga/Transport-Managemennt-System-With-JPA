/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.tpmgt.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
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
import lk.ijse.tpmgt.business.custom.ExpenceDetailBO;
import lk.ijse.tpmgt.business.custom.ExpenceTypeBO;
import lk.ijse.tpmgt.dto.ExpenceDetailDTO;
import lk.ijse.tpmgt.dto.ExpenceTypeDTO;
import lk.ijse.tpmgt.dto.VehicleDTO;
import lk.ijse.tpmgt.main.StartUp;
import lk.ijse.tpmgt.view.util.tblmodel.ExpenceTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageVehicleExpenceFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtExpenceType;
    @FXML
    private JFXComboBox<String> cmbVehicleRegNO;
    @FXML
    private JFXComboBox<String> cmbExpenceType;
    @FXML
    private JFXTextField txtType;
    @FXML
    private JFXDatePicker txtExpenceDate;
    @FXML
    private JFXTextField txtExpenceAmount;
    @FXML
    private JFXTextArea txtDescription;
    @FXML
    private TableView<ExpenceTM> tblExpence;
    @FXML
    private JFXButton btnAddDetail;
    @FXML
    private JFXButton btnAddTypeExprnce;
    
    private ExpenceTypeBO exprenceTypeBO;  
    //private 
    @FXML
    private JFXTextField txtTypeID;
    private ExpenceDetailBO expenceDetailBO;
    public ManageVehicleExpenceFormController() {
        this.exprenceTypeBO= (ExpenceTypeBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.EXPENCETYPE);
        this.expenceDetailBO= (ExpenceDetailBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.EXPENCEDETAIL);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblExpence.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("regNo"));
        tblExpence.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("exId"));
        tblExpence.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblExpence.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblExpence.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("description"));
        loadVehicleIDCombo();
        loadAllExpences();
        loadExpenceTypeIDCombo();
        // TODO
    }    

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
        
    }

    @FXML
    private void btnAddDetailOnAction(ActionEvent event) {
        save();
        
    }

    @FXML
    private void btnAddTypeOnAction(ActionEvent event) {
        String typeID = txtTypeID.getText();
        String typeName = txtExpenceType.getText();
        
        ExpenceTypeDTO expenceTypeDTO = new ExpenceTypeDTO(typeID, typeName);
        try {
            boolean result = exprenceTypeBO.saveExpenceType(expenceTypeDTO);
            if(result){
                new Alert(Alert.AlertType.INFORMATION,"New Expence Type Added",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Failed to Added New Expence Type",ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleExpenceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadVehicleIDCombo(){
        ArrayList<String> allIDS = new ArrayList<>(); 
        ArrayList<VehicleDTO> arr;
        try {
            arr = expenceDetailBO.getVehicleID();
            for (VehicleDTO vehicleDTO : arr) {
            String regNo = vehicleDTO.getRegNo();  
            allIDS.add(regNo);   
        }
            cmbVehicleRegNO.setItems(FXCollections.observableArrayList( allIDS));
            
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleExpenceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadExpenceTypeIDCombo(){
        ArrayList<String> allIDS = new ArrayList<>(); 
        ArrayList<ExpenceTypeDTO> arr;
        
        try {
            arr = exprenceTypeBO.getExpenceTypeID();
            for(ExpenceTypeDTO expenceTypeDTO: arr){
                String exId = expenceTypeDTO.getExId();
                allIDS.add(exId);
            }
               cmbExpenceType.setItems(FXCollections.observableArrayList(allIDS));
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleExpenceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exTypeIDComboOnAction(ActionEvent event) {
        String exId =cmbExpenceType.getValue();
        try {
            ExpenceTypeDTO type= exprenceTypeBO.findByID(exId);
            txtType.setText(type.getType());
            
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleExpenceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void save() {
        String regNo = cmbVehicleRegNO.getValue();
        String exId = cmbExpenceType.getValue();
        LocalDate date1 = txtExpenceDate.getValue();
        Date date =new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(date1.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ManageVehicleExpenceFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BigDecimal amount = new BigDecimal(txtExpenceAmount.getText());
        String description = txtDescription.getText();

        ExpenceDetailDTO expenceDetailDTO = new ExpenceDetailDTO(regNo, exId, date, amount, description);
        try {
            boolean result = expenceDetailBO.saveExpenceDetail(expenceDetailDTO);
            if (result) {
                new Alert(Alert.AlertType.CONFIRMATION, "Expence Detail Added Successfully", ButtonType.OK).show();
                loadAllExpences();
                //clearFields();
                //loadAllDrivers();
            } else {
                new Alert(Alert.AlertType.ERROR, "Faild to save Expence Detail", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageDriverFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadAllExpences() {
        
        try {
            ArrayList<ExpenceDetailDTO> allExpences = expenceDetailBO.getAllExpenceDetail();
            ObservableList<ExpenceTM> olExpences = tblExpence.getItems();
            olExpences.removeAll(olExpences);

            for (ExpenceDetailDTO expenceDetail : allExpences) {
                ExpenceTM expenceTM = new ExpenceTM(expenceDetail.getDate(),
                        expenceDetail.getRegNo(),
                        expenceDetail.getExId(),
                        expenceDetail.getAmount(),
                        expenceDetail.getDescription());
                      
                        
                olExpences.add(expenceTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}
