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
import static com.lowagie.text.xml.simpleparser.EntitiesToSymbol.map;
import java.io.InputStream;
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
import lk.ijse.tpmgt.business.custom.SalaryBO;
import lk.ijse.tpmgt.db.HibernateUtil;
import lk.ijse.tpmgt.dto.DriverDTO;
import lk.ijse.tpmgt.dto.SalaryDTO;

import lk.ijse.tpmgt.main.StartUp;
import lk.ijse.tpmgt.view.util.tblmodel.SalaryTM;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageSalaryFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXComboBox<String> cmbNIC;
    @FXML
    private JFXDatePicker txtSDate;
    @FXML
    private JFXTextField txtBonus;
    @FXML
    private JFXTextField txtName;
    @FXML
    private TableView<SalaryTM> tblSalary;
    @FXML
    private JFXTextField txtAmountPerKm;
    @FXML
    private JFXButton btnPay;
    @FXML
    private JFXTextField txtSalaryID;
    
    private SalaryBO salaryBO;
    
    private DriverBO driverBO;
    
    private ArrayList<DriverDTO> driverDetailsList;
    
    private ArrayList<SalaryDTO> salaryDetailsList;
    @FXML
    private JFXButton btnReport;

    public ManageSalaryFormController() {
        this.salaryBO = (SalaryBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.SALARY);
        this.driverBO = (DriverBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.DRIVER);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblSalary.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sId"));
        tblSalary.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblSalary.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sDate"));
        tblSalary.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("amountPerKm"));
        tblSalary.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("totalKm"));
        tblSalary.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("earn"));
        tblSalary.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("bonus"));
        tblSalary.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("total"));
        loadCmbNic();
        loadSalaryDetails();

    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void cmbNic(ActionEvent event) {

        String nic = cmbNIC.getValue();
        for (DriverDTO driverDTO : driverDetailsList) {
            if (nic.equals(driverDTO.getNic())) {
                txtName.setText(driverDTO.getName());
                loadDriverSalaryDetailsToTable(nic);
                break;
            }
        }
    }

    @FXML
    private void btnPayOnAction(ActionEvent event) {
         String sId = txtSalaryID.getText();
         String bonus = txtBonus.getText();
         String amountPerKm= txtAmountPerKm.getText();
         
         
           if (!sId.matches("^s\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Salary ID",ButtonType.OK).show();
            txtSalaryID.requestFocus();
            return;
           }
            if (!bonus.matches("^\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid input to bonus",ButtonType.OK).show();
            txtBonus.requestFocus();
            return;
           }
            if (!amountPerKm.matches("^\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid input to amount",ButtonType.OK).show();
            txtAmountPerKm.requestFocus();
            return;
           }
           
           pay();

    }
    
    private void pay(){
          String sId = txtSalaryID.getText();
          LocalDate date1 = txtSDate.getValue();
          Date date = new Date();
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse(date1.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         BigDecimal bonus = new BigDecimal(txtBonus.getText());
         BigDecimal amountPerKm= new BigDecimal(txtAmountPerKm.getText());
         String nic = cmbNIC.getValue();
         
         SalaryDTO salaryDTO=new SalaryDTO();
         salaryDTO.setAmountPerKm(amountPerKm);
         salaryDTO.setBonus(bonus);
         salaryDTO.setNic(nic);
         salaryDTO.setsDate(date);
         salaryDTO.setsId(sId);
         
        try {
            boolean result=salaryBO.saveSalary(salaryDTO);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Salary Payment succsessfully added",ButtonType.OK ).show();
                loadSalaryDetails();
                loadDriverSalaryDetailsToTable(nic);
            }else{
                new Alert(Alert.AlertType.ERROR,"Salary Payment added failed",ButtonType.OK ).show();
            }
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
            cmbNIC.setItems(FXCollections.observableArrayList(allIDS));
        } catch (Exception ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSalaryDetails() {
        try {
            this.salaryDetailsList = salaryBO.getAllSalary();

        } catch (Exception ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDriverSalaryDetailsToTable(String driverNic) {

        ObservableList<SalaryTM> olSalaries = tblSalary.getItems();
        olSalaries.removeAll(olSalaries);
        for (SalaryDTO sdto : salaryDetailsList) {
            if (driverNic.equals(sdto.getNic())) {
                
                SalaryTM salaryTM = new SalaryTM(
                        sdto.getsId(),
                        sdto.getNic(),
                        sdto.getsDate(),
                        sdto.getAmountPerKm(),
                        sdto.getTotalKm(),
                        sdto.getEarn(),
                        sdto.getBonus(),
                        sdto.getTotal());
                olSalaries.add(salaryTM);
            }

        }
    }

    @FXML
    private void btnOnActionReport(ActionEvent event) {
        try {
//            InputStream stm = getClass().getResourceAsStream("/lk/ijse/tpmgt/Report/Salary.jasper");
//            JasperPrint jasp = JasperFillManager.fillReport(stm, map, HibernateUtil.getInstance().getConnection());
//            JasperViewer.viewReport(jasp,false);

        } catch (Exception ex) {
            Logger.getLogger(ManageSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
