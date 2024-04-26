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
            primaryStage.setTitle("Welcome to AutoCamper");
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
            controller.setMainApplication(this);
            primaryStage.setScene(new Scene(root, 800, 545));
            primaryStage.setTitle("Book Your Camper");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Error loading booking page");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
