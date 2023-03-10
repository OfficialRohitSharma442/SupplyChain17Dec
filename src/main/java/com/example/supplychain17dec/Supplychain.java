package com.example.supplychain17dec;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Supplychain extends Application {
    public static final int width = 700, height = 600, headerBar = 50;
    Pane bodyPane = new Pane();

    private GridPane headerBar() {
        TextField searchText = new TextField();
        Button searchButton = new Button("Search");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setMinSize(bodyPane.getMinWidth(), headerBar - 10);
        gridPane.setAlignment(Pos.CENTER);
//     gridPane.setStyle("-fx-background-color:#224952");
        gridPane.add(searchText, 0, 0);
        gridPane.add(searchButton, 1, 0);
        return gridPane;
    }

    private GridPane loginPage() {
        Label emailLabel = new Label("Email");
        Label passwordLabel = new Label("Password");
        Label messsageLabel = new Label("Hello i am message");
        TextField emailTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("LogIn");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email = emailTextField.getText();
                String password = passwordField.getText();
                messsageLabel.setText(email + "$$" + password);
            }
        });
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setMinSize(bodyPane.getMinWidth(), bodyPane.getMinHeight());
        gridPane.setAlignment(Pos.CENTER);
//      gridPane.setStyle("-fx-background-color:#C0C0C0");
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        gridPane.add(messsageLabel, 1, 2);
        return gridPane;
    }

    private Pane createContent() {

        Pane root = new Pane();
        root.setPrefSize(width, height + headerBar);
        bodyPane.setMinSize(width, height);
        bodyPane.setTranslateY(headerBar);
        bodyPane.getChildren().addAll(loginPage());


        root.getChildren().addAll(headerBar(), bodyPane);
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}