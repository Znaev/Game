package ru.lexa.igra.factory;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.lexa.igra.levels.LevelSecond;
import ru.lexa.igra.storage.LevelStorage;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;


public class ButtonFactory {
    private static Random random = new Random(System.currentTimeMillis());

    private static void randomEvent(Stage mainStage, Scene mainScene) {
        Button btnBack = new Button("Вернуться");
        btnBack.setOnAction(ae -> mainStage.setScene(mainScene));
        int num = random.nextInt(2);
        if (num == 0) {
            Label forest = new Label("Это лес");
            BorderPane forestRoot = new BorderPane(forest);
            forestRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene forestScene = new Scene(forestRoot, 200, 150);
            mainStage.setScene(forestScene);
        }
        if (num == 1) {
            Label dungeon = new Label("Это подземелье");
            BorderPane dungeonRoot = new BorderPane(dungeon);
            dungeonRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene dungeonScene = new Scene(dungeonRoot, 200, 150);
            mainStage.setScene(dungeonScene);
        }
    }


    public static ArrayList<Button> firstGenerateButtons(int countButtons, Stage mainStage, Scene mainScene) {
        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < countButtons; i++) {
            Button button = new Button();
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setOnAction(ae -> randomEvent(mainStage, mainScene));
            buttons.add(button);
        }
        int indexKey = random.nextInt(countButtons);
        int index = random.nextInt(countButtons);
        while (index == indexKey) index = random.nextInt(countButtons);
        int indexDoor = index;
        LevelStorage.getInstance().setDoor(buttons.get(indexDoor));
        LevelStorage.getInstance().setKey(buttons.get(indexKey));
        LevelStorage.getInstance().getKey().setOnAction(ae -> LevelStorage.getInstance().getKey().setText("Ключ"));
        LevelStorage.getInstance().getDoor().setOnAction(ae ->
        {
            LevelStorage.getInstance().getDoor().setText("Дверь");
            LevelStorage.getInstance().getDoor().setOnAction(AE -> {
                if ( LevelStorage.getInstance().getKey().getText().equals("Ключ")) LevelSecond.startLevelSecond(mainStage);
            });
        });
        return buttons;
    }


    public static ArrayList<Button> secondGenerateButtons(int countButtons, Stage mainStage, Scene mainScene) {
        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < countButtons; i++) {
            Button button = new Button();
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setOnAction(ae -> randomEvent(mainStage, mainScene));
            buttons.add(button);
        }
        int indexKey = random.nextInt(countButtons);
        int index = random.nextInt(countButtons);
        while (index == indexKey) index = random.nextInt(countButtons);
        int indexDoor = index;
        LevelStorage.getInstance().setDoor(buttons.get(indexDoor));
        LevelStorage.getInstance().setKey(buttons.get(indexKey));
        LevelStorage.getInstance().getKey().setOnAction(ae -> LevelStorage.getInstance().getKey().setText("Ключ"));
        LevelStorage.getInstance().getDoor().setOnAction(ae ->
        {
            LevelStorage.getInstance().getDoor().setText("Дверь");
            LevelStorage.getInstance().getDoor().setOnAction(AE -> {
                if ( LevelStorage.getInstance().getKey().getText().equals("Ключ"))
                    LevelStorage.getInstance().getDoor().setText("Конец");
            });
        });
        return buttons;
    }
    }