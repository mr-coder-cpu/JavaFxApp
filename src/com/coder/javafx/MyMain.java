package com.coder.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

         MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    private MenuBar createMenu(){

        Menu fileMenu = new Menu("File");
        MenuItem newmenuItem = new MenuItem("New");

        newmenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newmenuItem, separatorMenuItem,  quitMenuItem);

        //Help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        //Menu bar
        MenuBar menuBar  = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;



    }

    private void aboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning javaFx");
        alertDialog.setContentText(" I am just a beginner soon i will be pro and and start developing Java games.");
       ButtonType yesButton = new ButtonType("Yes");
       ButtonType noButton = new ButtonType("No");

       alertDialog.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> clickBtn = alertDialog.showAndWait();

        if(clickBtn.isPresent() &&  clickBtn.get()==yesButton){
            System.out.println("Yes Button Clicked");
        }
        else {
            System.out.println("N0 Button Clicked");
        }


        alertDialog.show();

    }

    @Override
    public void stop() throws Exception{

        System.out.println("Stop");
        super.stop();
    }
}
