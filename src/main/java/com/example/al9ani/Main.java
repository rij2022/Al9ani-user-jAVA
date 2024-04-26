package com.example.al9ani;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.user.DataUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the sign-in page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/user/signup.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        // Set the scene to the stage and show the stage
        stage.setScene(scene);
        stage.setTitle("Welcome!");
        stage.setMinWidth(600);
        stage.setMaxHeight(400);
        stage.show();

        // Establish the database connection

        try {
            Connection conn = DataUtils.getConnection();
            System.out.println("Connexion réussie!");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
