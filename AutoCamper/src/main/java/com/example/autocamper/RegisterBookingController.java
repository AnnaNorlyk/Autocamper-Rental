package com.example.autocamper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterBookingController {
    public CheckBox SuperCoverPlusCheck;
    public MenuButton AutoCamperTypeMenu;
    public CheckBox BasicInsuranceCheck;
    public TextField EmailTextField;
    public TextField NameTextField;
    public Button SaveButton;
    public DatePicker DateOfBookingPicker;
    public MenuButton AutoCamperMenu;
    public TextField AddressTextField;
    public Button ReturnButton;
    private HelloApplication helloApplication;

    public void setMainApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        try {
            HelloApplication helloApplication1 = helloApplication;
            helloApplication1.showStartPage();
        } catch (Exception e) {
            System.out.println("Error while returning to Start Page: " + e.getMessage());
        }
    }


    public void handleSuperCoverPlusCheck(ActionEvent actionEvent) {
    }

    public void handleBasicInsuranceCheck(ActionEvent actionEvent) {
    }

    public void handleSaveButton(ActionEvent actionEvent) {
    }

    public void handleAutoCamperTypeMenu(ActionEvent actionEvent) {
    }

    public void handleNameText(ActionEvent actionEvent) {
    }

    public void handleAlternativeName(ActionEvent actionEvent) {
    }

    public void handleAddressTextField(ActionEvent actionEvent) {
    }

    public void handleEmailTextField(ActionEvent actionEvent) {
    }

    public void handleAutoCamperMenu(ActionEvent actionEvent) {

    }

    public void handleDateOfBooking(ActionEvent actionEvent) {
    }

    public void handleStartDate(ActionEvent actionEvent) {
    }

    public void handleEndDate(ActionEvent actionEvent) {
    }

}
