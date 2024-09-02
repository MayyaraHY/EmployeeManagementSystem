package tn.controllers;

import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import tn.models.Employees;
import tn.models.Vacation;
import tn.services.VacationService;

import java.io.File;
import java.io.IOException;
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
    private MFXLegacyListView<Vacation> vancationList;

    VacationService vacationService = new VacationService();

    private Employees employee;
    public void setPassedItem(Employees employee){
        this.employee = employee;
    }

    @FXML
    void addVacationFunction(MouseEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddVacation.fxml"));
            Parent root = loader.load();

            // Get the controller of the addVacation.fxml
            AddVacation addVacationController = loader.getController();

            // Set CIN and Employee ID in the new window
            String employeeCIN = CINid.getText(); // Assuming CINField holds the current employee CIN
            addVacationController.setEmployeeDetails(employeeCIN);

            Scene currentScene = ((Node) event.getSource()).getScene();

            if (currentScene != null) {
                currentScene.setRoot(root);
            } else {
                System.out.println("Error: currentScene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file.");
        }

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

        vancationList.setCellFactory(param -> new ListCell<>() {

            protected void updateItem(Vacation vacation, boolean empty) {
                super.updateItem(vacation, empty);

                if (empty || vacation == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    GridPane container = new GridPane();

                    TextFlow textFlow = new TextFlow();


                    String labelStyle = "-fx-fill: #9b8385;  -fx-font-size: 27  ;";
                    String nameStyle = "-fx-fill: #8b7080;  -fx-font-size: 40;";

                    String dataStyle = "-fx-fill: #9b8385; -fx-font-size: 20;";




                    Text startDateText = new Text("Début: ");
                    startDateText.setStyle(labelStyle);
                    Text startDateData  = new Text(vacation.getStartDate() + "\n");
                    startDateData.setStyle(dataStyle);

                    Text endDateText = new Text("Fin: ");
                    endDateText.setStyle(labelStyle);
                    Text endDateData = new Text(vacation.getEndDate() + "\n");
                    endDateData.setStyle(dataStyle);

                    Text reasontext = new Text("Réson: ");
                    reasontext.setStyle(labelStyle);
                    Text reasonData = new Text(vacation.getReason() + "\n");
                    reasonData.setStyle(dataStyle);

                    Text descriptionText = new Text("Description: ");
                    descriptionText.setStyle(labelStyle);
                    Text descriptionData = new Text(vacation.getDescriptionVac() + "\n");
                    descriptionData.setStyle(dataStyle);

                    startDateText.setWrappingWidth(200);
                    startDateData.setWrappingWidth(200);
                    endDateText.setWrappingWidth(200);
                    endDateData.setWrappingWidth(200);
                    reasontext.setWrappingWidth(200);
                    reasonData.setWrappingWidth(200);
                    descriptionText.setWrappingWidth(200);
                    descriptionData.setWrappingWidth(200);



                    //Setting icons for the buttons
                    //1 load images
                    String deleteIconPath = "file:D:\\mmm\\mmm\\2023-2024 3A14\\Stage\\ComplexePilote\\src\\main\\resources\\icons\\delete.png";
                    Image deleteIcon = new Image(deleteIconPath);

                    String updateIconPath = "file:D:\\mmm\\mmm\\2023-2024 3A14\\Stage\\ComplexePilote\\src\\main\\resources\\icons\\edit.png";
                    Image updateIcon = new Image(updateIconPath);

                    //2 set image view
                    ImageView deleteIconView = new ImageView(deleteIcon);
                    deleteIconView.setFitWidth(25);
                    deleteIconView.setFitHeight(25);

                    ImageView updateIconView = new ImageView(updateIcon);
                    updateIconView.setFitWidth(25);
                    updateIconView.setFitHeight(25);

                    // Create "Update" and "Delete" buttons
                    Button updateButton = new Button();
                    updateButton.setGraphic(updateIconView);
                    Button deleteButton = new Button();
                    deleteButton.setGraphic(deleteIconView);

                    //removing background
                    deleteButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
                    updateButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

                    // Add buttons in a VBox to stack them vertically
                    VBox buttonContainer = new VBox(10); // Vertical spacing of 10
                    buttonContainer.getChildren().addAll(deleteButton, updateButton);
                    buttonContainer.setAlignment(Pos.CENTER_RIGHT);
                    buttonContainer.setPadding(new Insets(0, 0, 0, 30)); // Padding for right alignment



                    textFlow.getChildren().addAll(startDateText, startDateData, endDateText, endDateData, reasontext, reasonData, descriptionText, descriptionData );
                    textFlow.setPadding(new Insets(20, 0, 0,20 ));

                    container.add(textFlow, 1, 0); // Employee details in the middle
                    container.add(buttonContainer, 2, 0); // Buttons on the right side



                    // Adjust column widths
                    ColumnConstraints col1 = new ColumnConstraints(150); // Image column
                    ColumnConstraints col2 = new ColumnConstraints(300); // Text column
                    ColumnConstraints col3 = new ColumnConstraints(100); // Button column
                    container.getColumnConstraints().addAll(col1, col2, col3);
                    container.setHgap(30); // Horizontal gap between columns

                    setGraphic(container); // Set the constructed UI as the cell graphic

                }
            }
        });

        vancationList.getItems().addAll(vacationService.getVacationsByEmployeeId(employee.getIdEmployee()));



    }
}
