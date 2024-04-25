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
    private HelloApplication helloApplication;

    // This method sets a reference to the main application class
    public void setMainApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

    // Handles the "New Booking" button
    @FXML
    public void handleNewBookingButton(ActionEvent event) {
        helloApplication.showRegisterBookingPage();
        }
    }


