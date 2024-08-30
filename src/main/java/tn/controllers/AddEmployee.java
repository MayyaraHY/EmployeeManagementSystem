package tn.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.models.Employees;
import tn.services.EmployeeService;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddEmployee {

    @FXML
    private TextField CINField;

    @FXML
    private Text CINid;

    @FXML
    private TextField imageURLid;

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

    private final EmployeeService employeeService = new EmployeeService();


    @FXML
    void browse(ActionEvent event) {
        Stage primaryStage = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a File");

        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            String fileUrl = selectedFile.toURI().toString();
            imageURLid.setText(fileUrl);
        }
    }

    @FXML
    void addEmployeeButton(ActionEvent event) {

        String t1 = imageURLid.getText().replace("%20", " ");
        t1 = t1.replace("/", "\\").replace("file:\\", "");

        // Get date values
        LocalDate birthday = birthdayField.getValue();
        LocalDate startDate = startDateFiels.getValue();

        // Regex for email validation
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Validation
        if (nameField.getText().isEmpty() ||
                firstNameField.getText().isEmpty() ||
                phoneField.getText().isEmpty() ||
                positionField.getText().isEmpty() ||
                CINField.getText().isEmpty() ||
                emailField.getText().isEmpty() ||
                salaryField.getText().isEmpty() ||
                birthday == null ||
                startDate == null) {

            // Alert for empty fields or missing dates
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("Merci de remplir tous les champs, y compris les dates.");
            alert.showAndWait();

        } else if (!emailPattern.matcher(emailField.getText()).matches()) {

            // Alert for invalid email format
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Email");
            alert.setContentText("Merci de saisir une adresse e-mail valide.");
            alert.showAndWait();

        } else if (phoneField.getText().length() != 8 || !phoneField.getText().matches("\\d+")) {

            // Alert for invalid phone number
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Phone Number");
            alert.setContentText("Le numéro de téléphone doit contenir exactement 8 chiffres.");
            alert.showAndWait();

        } else if (CINField.getText().length() != 8 || !CINField.getText().matches("\\d+")) {

            // Alert for invalid CIN
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid CIN");
            alert.setContentText("Le CIN doit contenir exactement 8 chiffres.");
            alert.showAndWait();

        } else if (!salaryField.getText().matches("\\d+\\.?\\d*")) {

            // Alert for invalid salary
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Salary");
            alert.setContentText("Le salaire doit être un nombre valide.");
            alert.showAndWait();

        } else {
            // All fields are valid, proceed with adding the employee
            Date sqlBirthday = Date.valueOf(birthday);
            Date sqlStartDate = Date.valueOf(startDate);

            Employees employeeToAdd = new Employees(
                    nameField.getText(),
                    firstNameField.getText(),
                    CINField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    t1,
                    sqlBirthday,
                    gendreField.getText(),
                    positionField.getText(),
                    sqlStartDate,
                    Float.parseFloat(salaryField.getText())
            );

            employeeService.add(employeeToAdd);
        }
    }
}