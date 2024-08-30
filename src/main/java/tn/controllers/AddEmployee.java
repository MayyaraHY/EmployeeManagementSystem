package tn.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployee implements Initializable {

    @FXML
    private TextField CINField;

    @FXML
    private Text CINid;

    @FXML
    private TextField URLField;

    @FXML
    private AnchorPane background;

    @FXML
    private Text birthdateId;

    @FXML
    private DatePicker birthdayField;

    @FXML
    private TextField emailField;

    @FXML
    private Text emailId;

    @FXML
    private TextField firstNameField;

    @FXML
    private Text firstNameId;

    @FXML
    private MenuButton gendreField;

    @FXML
    private Text gendreId;

    @FXML
    private Text imageId;

    @FXML
    private TextField nameField;

    @FXML
    private Text nameid;

    @FXML
    private TextField phoneField;

    @FXML
    private Text phoneId;

    @FXML
    private TextField positionField;

    @FXML
    private Text positionid;

    @FXML
    private TextField salaryField;

    @FXML
    private Text salaryId;

    @FXML
    private MFXButton saveButton;

    @FXML
    private DatePicker startDateFiels;

    @FXML
    private Text startdateId;

    @FXML
    private Button uploadButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    @FXML
    void UploadImageURLFunction(ActionEvent event) {

    }

    @FXML
    void addEmployeeButton(ActionEvent event) {

    }


}
