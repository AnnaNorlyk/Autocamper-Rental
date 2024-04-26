package com.example.autocamper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class RegisterBookingController {
    @FXML
    public CheckBox superCoverPlusCheck;
    @FXML
    public MenuButton autoCamperTypeMenu;
    @FXML
    public CheckBox basicInsuranceCheck;
    @FXML
    public TextField emailTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public Button saveButton;

    @FXML
    public MenuButton autoCamperMenu;
    @FXML
    public TextField addressTextField;
    @FXML
    public Button returnButton;
    @FXML
    public DatePicker startDatePicker;

    public DatePicker endDatepicker;
    private HelloApplication helloApplication;

    String name;

    public  String address;

    public String email;

    public int autocamperType;

    public Date startDate;
    public Date endDate;

    public boolean basicInsurance;
    public boolean superCoverPlus;

    public DatePicker dateOfBooking;


    public void setMainApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        try {
            if (helloApplication != null) {
                helloApplication.showStartPage();
            } else {
                System.out.println("Application reference is not set.");
            }
        } catch (Exception e) {
            System.out.println("Error while returning to Start Page: " + e.getMessage());
        }
    }


    public void handleSuperCoverPlusCheck(ActionEvent actionEvent) {
        try {
            // Retrieve the source of the event, assuming its a CheckBox
            CheckBox superCoverPlusCheckBox = (CheckBox) actionEvent.getSource();

            // Check if the CheckBox is selected or not
            boolean isSelected = superCoverPlusCheckBox.isSelected();

            // Update the superCoverPlus variable
            superCoverPlus = isSelected;
        } catch (ClassCastException e) {
            System.out.println("Error handling super cover plus check: " + e.getMessage());
        }

    }

    public void handleBasicInsuranceCheck(ActionEvent actionEvent) {
        CheckBox basicInsuranceCheckBox = (CheckBox) actionEvent.getSource();

        // Check if the CheckBox is selected or not
        boolean isSelected = basicInsuranceCheckBox.isSelected();

        // Update the basicInsurance variable accordingly
        basicInsurance = isSelected;
    }

    public void handleAutoCamperTypeMenu(ActionEvent actionEvent) {
    }

    public void handleNameText(ActionEvent actionEvent) {
        // Handle the event when the user types in the name text field
        TextField nameTextField = (TextField) actionEvent.getSource();
        name = nameTextField.getText();
    }

    public void handleAlternativeName(ActionEvent actionEvent) {
    }

    public void handleAddressTextField(ActionEvent actionEvent) {
        TextField addressTextField = (TextField) actionEvent.getSource();
        address = addressTextField.getText();

    }

    public void handleEmailTextField(ActionEvent actionEvent) {
        TextField emailTextField = (TextField) actionEvent.getSource();
        email = emailTextField.getText();
    }

    public void handleAutoCamperMenu(ActionEvent actionEvent) {

    }

    public void handleDateOfBooking(ActionEvent actionEvent) {
        try {
            // Retrieve the source of the event, assuming it's a DatePicker
            DatePicker datePicker = (DatePicker) actionEvent.getSource();

            // Get the selected date from the DatePicker
            LocalDate selectedDate = datePicker.getValue();

            // Perform any necessary actions with the selected date


        } catch (ClassCastException e) {
            System.out.println("Error handling date of booking: " + e.getMessage());
        }
    }

    public void handleStartDate(ActionEvent actionEvent) {
        try {
            // Retrieve the source of the event, assuming it's a DatePicker
            DatePicker startDatePicker = (DatePicker) actionEvent.getSource();

            // Get the selected start date from the DatePicker
            LocalDate selectedStartDate = startDatePicker.getValue();

            // Update the startDate variable accordingly
            startDate = Date.valueOf(selectedStartDate);

        } catch (ClassCastException e) {
            System.out.println("Error handling start date: " + e.getMessage());
        }
    }


    public void handleEndDate(ActionEvent actionEvent) {
        try {
            // Retrieve the source of the event, assuming it's a DatePicker
            DatePicker endDatePicker = (DatePicker) actionEvent.getSource();

            // Get the selected end date from the DatePicker
            LocalDate selectedEndDate = endDatePicker.getValue();

            // Update the endDate variable accordingly
            endDate = Date.valueOf(selectedEndDate);

        } catch (ClassCastException e) {
            System.out.println("Error handling end date: " + e.getMessage());
        }
    }



    @FXML
    private void handleSaveButton(ActionEvent event) {
        try {
            if (nameTextField != null) {
                String name = nameTextField.getText();
                String address = addressTextField.getText();
                String email = emailTextField.getText();

                int autocamperType = 0; // You need to implement logic to get the autocamper type

                // Retrieve the state of basic insurance and super cover plus check boxes
                boolean basicInsurance = basicInsuranceCheck.isSelected();
                boolean superCoverPlus = superCoverPlusCheck.isSelected();

                // You don't need to call handleStartDate here, just use the startDate variable
                Date startDate = this.startDate;

                // Get the end date from the date picker directly
                Date endDate = this.endDate;

                // call the rentRV method
                RegisterBookingWallet.rentRV(name, address, email, autocamperType, startDate, endDate, basicInsurance, superCoverPlus);
            } else {
                System.out.println("nameTextField is null. Make sure it is properly initialized in the FXML file.");
            }
        } catch (SQLException e) {
            System.out.println("Error while saving booking: " + e.getMessage());
        }
    }

    @FXML
    public void handleAutoCamperTypeSelection(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        autoCamperTypeMenu.setText(source.getText());
        updateAutoCamperMenu(source.getText());
    }


    public void updateAutoCamperMenu(String type) {
        autoCamperMenu.getItems().clear();  // Clears existing items
        int typeId = getTypeID(type);  // Method to convert type to an ID (int) for database retrieval

        try {
            List<Integer> camperIDs = DBAccess.getAutoCampersByType(typeId); // Call method from DBAccess
            for (Integer camperId : camperIDs) {
                MenuItem newItem = new MenuItem("Camper:" + camperId);
                autoCamperMenu.getItems().add(newItem);
                newItem.setOnAction(this::handleAutoCamperMenuSelection); // Handles selection
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve camper IDs: " + e.getMessage());
        }

    }

    private int getTypeID(String type) {
        switch (type) {
            case "Basic": return 0;
            case "Standard": return 1;
            case "Luxury": return 2;
            default: return -1;
        }
    }

    public void handleAutoCamperMenuSelection(ActionEvent event) {
        MenuItem selected = (MenuItem) event.getSource();
        System.out.println("Selected Camper: " + selected.getText());
    }

}
