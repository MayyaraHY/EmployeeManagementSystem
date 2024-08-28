package tn.controllers;

import io.github.palexdev.materialfx.controls.legacy.MFXLegacyListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import tn.models.Employees;
import tn.services.EmployeeService;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayEmployees implements Initializable {

    @FXML
    private ImageView employeeImage;

    @FXML
    private MFXLegacyListView<Employees> employeesList;

    @FXML
    private Text firstName;

    @FXML
    private Text idCIN;

    @FXML
    private Text lastName;


    EmployeeService employeeService = new EmployeeService();
    Employees employee = new Employees();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        employeesList.setCellFactory(param -> new ListCell<>() {

            protected void updateItem(Employees employee, boolean empty) {
                super.updateItem(employee, empty);

                if (empty || employee == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    GridPane container = new GridPane();

                    TextFlow textFlow = new TextFlow();


                    String labelStyle = "-fx-fill: #9b8385;  -fx-font-size: 27  ;";
                    String nameStyle = "-fx-fill: #8b7080;  -fx-font-size: 40;";

                    String dataStyle = "-fx-fill: #9b8385; -fx-font-size: 20;";




                    Text lastNameText = new Text("Nom: ");
                    lastNameText.setStyle(labelStyle);
                    Text lastNameData  = new Text(employee.getLastNameEmployee() + "\n");
                    lastNameData.setStyle(dataStyle);

                    Text firstNameText = new Text("Prénom: ");
                    firstNameText.setStyle(labelStyle);
                    Text firstNameData = new Text(employee.getNameEmployee() + "\n");
                    firstNameData.setStyle(dataStyle);

                    Text CINText = new Text("CIN: ");
                    CINText.setStyle(labelStyle);
                    Text CINData = new Text(employee.getCIN() + "\n");
                    CINData.setStyle(dataStyle);

                    VBox textContainer = new VBox(10);
                    textContainer.getChildren().addAll(lastNameText,lastNameData, firstNameText,firstNameData, CINText, CINData);
                    textContainer.setAlignment(Pos.CENTER);
                    textContainer.setPadding(new Insets(20,0,0,0));


                    String imagePath = employee.getImageEmployee();
                    Image productImage = new Image(new File(imagePath).toURI().toString());
                    ImageView imageView = new ImageView(productImage);
                    imageView.setFitHeight(150);
                    imageView.setFitWidth(150);
                    CINData.setWrappingWidth(200);
                    lastNameData.setWrappingWidth(200);
                    lastNameText.setWrappingWidth(200);
                    firstNameData.setWrappingWidth(200);
                    firstNameText.setWrappingWidth(200);

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



                    textFlow.getChildren().addAll(lastNameText, lastNameData, firstNameText, firstNameData, CINText, CINData );
                    container.add(imageView, 0, 0); // Image on the left
                    container.add(textFlow, 1, 0); // Employee details in the middle
                    container.add(buttonContainer, 2, 0); // Buttons on the right side

                    // Adjust column widths
                    ColumnConstraints col1 = new ColumnConstraints(150); // Image column
                    ColumnConstraints col2 = new ColumnConstraints(300); // Text column
                    ColumnConstraints col3 = new ColumnConstraints(100); // Button column
                    container.getColumnConstraints().addAll(col1, col2, col3);
                    container.setHgap(30); // Horizontal gap between columns

                    setGraphic(container); // Set the constructed UI as the cell graphic



                    //System.out.println("image path : " +imagePath );

                }
            }
        });

        employeesList.getItems().addAll(employeeService.getAllEmployees());


    }
}
