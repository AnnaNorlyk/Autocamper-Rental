package com.example.autocamper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showStartPage();
    }

    public void showStartPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartPage.fxml"));
            Parent root = loader.load();
            StartPageController controller = loader.getController();
            controller.setMainApplication(this);
            primaryStage.setScene(new Scene(root, 800, 545));
            primaryStage.setTitle("AutoCamper");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void showRegisterBookingPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterBooking.fxml"));
            Parent root = loader.load();
            RegisterBookingController controller = loader.getController();
            controller.setMainApplication(this); // This sets the application reference
            primaryStage.setScene(new Scene(root, 800, 545));
            primaryStage.setTitle("Register Booking");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error loading Register Booking Page: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
