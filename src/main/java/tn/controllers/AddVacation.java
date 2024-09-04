package tn.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.models.Vacation;
import tn.services.EmployeeService;
import tn.services.VacationService;

import java.sql.Date;
import java.time.LocalDate;

public class AddVacation {

    @FXML
    private TextField CINField;

    @FXML
    private TextField descriptionField;

    @FXML
    private DatePicker endDateField;

    @FXML
    private TextField reasonField;

    @FXML
    private MFXButton saveButton;

    @FXML
    private DatePicker startDateFiels;




    EmployeeService employeeService = new EmployeeService();
    VacationService vacationService = new VacationService();


    public void setEmployeeDetails(String CIN) {
        CINField.setText(CIN);
      //  CINField.setDisable(true);
    }




    @FXML
    void addVacationButton(ActionEvent event) {

        int id = employeeService.fetchEmployeeIdFromCIN(CINField.getText());
        //System.out.println(id);


        String cin = CINField.getText();
        if (cin == null || cin.trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Invalid CIN", "Le champ CIN ne peut pas être vide."
            );
            return;
        }

        //check if CIN mawjoud
        if (id == -1) {
            showAlert(Alert.AlertType.ERROR, "CIN Not Found", "Le CIN que vous avez entré n'existe pas.");
            return;
        }

        LocalDate startDate = startDateFiels.getValue();
        LocalDate endDate = endDateField.getValue();

        if (startDate == null || endDate == null) {
            showAlert(Alert.AlertType.ERROR, "Invalid Dates", "Veuillez sélectionner la date de début et la date de fin.");
            return;
        }

        if (endDate.isBefore(startDate)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Date Range", "La date de fin ne peut pas être antérieure à la date de début.");
            return;
        }

        Date sqlStartDate = Date.valueOf(startDate);
        Date sqlEndDate = Date.valueOf(endDate);

        Vacation vacationVacationToAdd = new Vacation(
                id,
                sqlStartDate,
                sqlEndDate,
                reasonField.getText(),
                descriptionField.getText()
        );

        vacationService.add(vacationVacationToAdd);
    }



    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
