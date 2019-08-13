package ru.lexa.igra;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

public class Main extends Application {
    private Button btnDoor = new Button(" ");
    private Button btnKey = new Button(" ");
    private Button btnForest = new Button(" ");
    private Button btnDungeon = new Button(" ");
    private Button btnBack = new Button("Вернуться");
    @Override
    public void start(final Stage primaryStage) {
        GridPane MainRoot = new GridPane();
        MainRoot.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Игра");
        Scene MainScene = new Scene(MainRoot, 300, 275);
        primaryStage.setScene(MainScene);
        //final Stage SecondWindow = new Stage();
        //SecondWindow.setTitle("Второе Окно");
        //SecondWindow.initModality(Modality.WINDOW_MODAL);
        //SecondWindow.initOwner(primaryStage);
        //SecondWindow.setX(primaryStage.getX()+ 200);
        //SecondWindow.setY(primaryStage.getY()+ 100);

        btnBack.setOnAction(ae -> primaryStage.setScene(MainScene));

        btnDoor.setOnAction(ae -> {
            Label Door = new Label("Это дверь");
            BorderPane DoorRoot = new BorderPane(Door);
            DoorRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene DoorScene = new Scene(DoorRoot, 200, 150);
            primaryStage.setScene(DoorScene);
        });
        btnKey.setOnAction(ae -> {
            Label Key = new Label("Это ключ");
            BorderPane KeyRoot = new BorderPane(Key);
            KeyRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene KeyScene = new Scene(KeyRoot, 200, 150);
            primaryStage.setScene(KeyScene);
        });
        btnForest.setOnAction(ae -> {
            Label Forest = new Label("Это лес");
            BorderPane ForestRoot = new BorderPane(Forest);
            ForestRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene ForestScene = new Scene(ForestRoot, 200, 150);
            primaryStage.setScene(ForestScene);
        });
        btnDungeon.setOnAction(ae -> {
            Label Dungeon = new Label("Это подземелье");
            BorderPane DungeonRoot = new BorderPane(Dungeon);
            DungeonRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene DungeonScene = new Scene(DungeonRoot, 200, 150);
            primaryStage.setScene(DungeonScene);
        });
        MainRoot.add(btnKey, 0, 0);
        MainRoot.add(btnDoor, 1, 1);
        MainRoot.add(btnDungeon, 0, 1);
        MainRoot.add(btnForest, 1, 0);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
