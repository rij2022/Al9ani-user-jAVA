package com.example.al9ani;

import controller.user.ProfileSetting;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.user.UserService;
import utils.user.DataUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
    UserService us= new UserService();
    @Override
    public void start(Stage stage) throws IOException {
   String username= us.autoLogin();
     System.out.println("hereeee please "+us.autoLogin());

        if(username !=null){
            if (username.equals("admin")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/adminD/dashboard.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(root));

                primaryStage.initStyle(StageStyle.UNDECORATED);


                primaryStage.show();

                return;
            }else {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/profilesetting.fxml"));
                Parent root = loader.load();
                ProfileSetting profileSetting = loader.getController();
                try {
                    profileSetting.setUserInformation(username);
                } catch (SQLException e) {
                    System.err.println(e);
                }
                // Set the scene to the primary stage
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();}

        }
        // Load the FXML file for the sign-in page
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/user/signup.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        // Set the scene to the stage and show the stage
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
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
