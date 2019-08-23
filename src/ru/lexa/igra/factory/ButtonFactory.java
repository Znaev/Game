package ru.lexa.igra.factory;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.lexa.igra.Levels.LevelSecond;

import java.util.ArrayList;
import java.util.Random;


public class ButtonFactory {
    private static Random random = new Random(System.currentTimeMillis());

    private static void randomEvent(Stage MainStage, Scene MainScene) {
        Button btnBack = new Button("Вернуться");
        btnBack.setOnAction(ae -> MainStage.setScene(MainScene));
        int num = random.nextInt(2);
        if (num == 0) {
            Label forest = new Label("Это лес");
            BorderPane forestRoot = new BorderPane(forest);
            forestRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene forestScene = new Scene(forestRoot, 200, 150);
            MainStage.setScene(forestScene);
        }
        if (num == 1) {
            Label dungeon = new Label("Это подземелье");
            BorderPane dungeonRoot = new BorderPane(dungeon);
            dungeonRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene dungeonScene = new Scene(dungeonRoot, 200, 150);
            MainStage.setScene(dungeonScene);
        }
    }


    public static ArrayList<Button> firstGenerateButtons(int countButtons, Stage mainStage, Scene MainScene) {
        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < countButtons; i++) {
            Button button = new Button();
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setOnAction(ae -> randomEvent(mainStage, MainScene));
            buttons.add(button);
        }
        int indexKey = random.nextInt(countButtons);
        int index = random.nextInt(countButtons);
        while (indexKey == index) {
            index = random.nextInt(countButtons);
        }
        int indexDoor = index;
        buttons.get(indexKey).setOnAction(ae ->
            buttons.get(indexKey).setText("Ключ"));
        buttons.get(indexDoor).setOnAction(ae ->
        {
            buttons.get(indexDoor).setText("Дверь");
            buttons.get(indexDoor).setOnAction(AE -> {
                if (buttons.get(indexKey).getText().equals("Ключ")) {
                    LevelSecond.startLevelSecond(mainStage);
                }
            });
        });
        return buttons;
    }


    public static ArrayList<Button> secondGenerateButtons(int countButtons, Stage MainStage, Scene MainScene) {
        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < countButtons; i++) {
            Button button = new Button();
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setOnAction(ae -> randomEvent(MainStage, MainScene));
            buttons.add(button);
        }
        int indexKey = random.nextInt(countButtons);
        int index = random.nextInt(countButtons);
        while (indexKey == index) {
            index = random.nextInt(countButtons);
        }
        int indexDoor = index;
        buttons.get(indexKey).setOnAction(ae ->
            buttons.get(indexKey).setText("Ключ"));
        buttons.get(indexDoor).setOnAction(ae ->
        {
            buttons.get(indexDoor).setText("Дверь");
            buttons.get(indexDoor).setOnAction(AE -> {
                if (buttons.get(indexKey).getText().equals("Ключ")) {
                    buttons.get(indexDoor).setText("Конец");
                }
            });
        });
        return buttons;
    }


}
