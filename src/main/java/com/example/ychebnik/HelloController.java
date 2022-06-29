package com.example.ychebnik;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scroll_id;

    @FXML
    private TextArea id_pane;

    @FXML
    private Button liter_id;

    @FXML
    private Button test_id;

    @FXML
    private Button razd1;

    @FXML
    private Button razd2;

    @FXML
    private Button razd3;

    @FXML
    private Button razd4;

    @FXML
    private Button razd5;

    @FXML
    private Button razd6;

    @FXML
    void initialize() {

        razd1.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema1.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });
        razd2.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema2.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        razd3.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema3.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        razd4.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema4.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        razd5.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema5.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        razd6.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("tema6.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        liter_id.setOnAction(actionEvent ->  {

            Scanner scanner = null;
            try {
                String content = Files.lines(Paths.get("liter.txt")).reduce("", String::concat);

                scanner = new Scanner(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                assert scanner != null;
                if (!scanner.hasNextLine()) break;
                id_pane.setText(scanner.nextLine());
            }
            scanner.close();

        });

        test_id.setOnAction(actionEvent -> {                //событие для кнопки
            openNewScene("test.fxml");
        });

    }

    public void openNewScene(String window) {
        test_id.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent par = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Электронное учебное пособие");
        stage.setResizable(false);
        stage.setScene(new Scene(par));
        stage.show();
    }
}