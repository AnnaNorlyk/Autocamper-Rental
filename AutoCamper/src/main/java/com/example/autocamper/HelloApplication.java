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
            primaryStage.setScene(new Scene(root, 1280, 800));
            primaryStage.setTitle("Welcome to AutoCamper");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBookingPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterBooking.fxml"));
            Parent root = loader.load();
            RegisterBookingController controller = loader.getController();
            controller.setMainApplication(this);
            primaryStage.setScene(new Scene(root, 1280, 800));
            primaryStage.setTitle("Book Your Camper");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
