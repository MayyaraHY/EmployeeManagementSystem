package tn.controllers;

import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import tn.models.Employees;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class EmployeeItem implements Initializable {

    @FXML
    private Text BDid;

    @FXML
    private Text CINid;

    @FXML
    private ImageView addVacButton;

    @FXML
    private Text firstNameid;

    @FXML
    private ImageView imageid;

    @FXML
    private Text mailid;

    @FXML
    private Text nameid;

    @FXML
    private Text phoneNumberid;

    @FXML
    private Text positionId;

    @FXML
    private MFXLegacyListView<?> vancationList;

    private Employees employee;
    public void setPassedItem(Employees employee){
        this.employee = employee;
    }

    @FXML
    void addVacationFunction(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            nameid.setText(employee.getLastNameEmployee());
            firstNameid.setText(employee.getNameEmployee());
            CINid.setText(employee.getCIN());
            positionId.setText(employee.getPositionEmployee());
            phoneNumberid.setText(employee.getPhoneEmployee());
            mailid.setText(employee.getEmailEmployee());

            //setting image
            String demonstrationPath = employee.getImageEmployee();
            Image demonstrationImage = new Image(new File(demonstrationPath).toURI().toString());
            imageid.setImage(demonstrationImage);

            //setting date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        BDid.setText(dateFormat.format(employee.getBirthdayEmployee()));

    }
}
