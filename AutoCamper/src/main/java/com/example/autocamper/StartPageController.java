package com.example.autocamper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StartPageController {
    public Button NewBookingButton;
    public TableView CalendarTableView;

    // This method sets a reference to the main application class
    public void setMainApplication(HelloApplication helloApplication) {
    }

    // Handles the "New Booking" button
    @FXML
    public void handleNewBookingButton(ActionEvent event) {
        try {
            // Loads the registration booking FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/autocamper/RegisterBooking.fxml"));

            Parent root = loader.load();

            // Gets the stage from button event
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Sets the new scene on the current stage with the loaded FXML layout
            stage.setScene(new Scene(root, 800, 545));
            stage.setTitle("Register Booking");
            stage.show();
        } catch (Exception e) {
            System.out.println("There was an error loading the Registration Page");
        }
    }
}
