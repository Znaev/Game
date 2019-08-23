package ru.lexa.igra.Levels;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.lexa.igra.factory.ButtonFactory;
import ru.lexa.igra.factory.ButtonRootFactory;
import ru.lexa.igra.factory.FlowPaneFactory;

import java.util.ArrayList;


public class LevelFirst {

    static public void startLevelFirst(Stage mainStage) {
        Label stat_health = new Label("Здоровье:");
        Label stat_stamina = new Label("Выносливость:");
        Label stat_gold = new Label("Золото:");
        Label stat_name = new Label("Имя:");
        double width = 300;
        double height = width * 1.5;
        int insetsCount = 5;
        int buttonsCount = 4;
        FlowPane characterStats = FlowPaneFactory.generateFlowPane(width, height, insetsCount,
                stat_name, stat_health, stat_stamina, stat_gold);
        FlowPane mainRoot = new FlowPane(Orientation.VERTICAL, characterStats);
        mainStage.setTitle("Игра");
        Scene mainScene = new Scene(mainRoot, width, height);
        mainStage.setScene(mainScene);
        ArrayList<Button> buttons = ButtonFactory.firstGenerateButtons(buttonsCount, mainStage, mainScene);
        GridPane buttonRoot = ButtonRootFactory.generateButtonRoot(width, height, buttonsCount, insetsCount, buttons);
        mainRoot.getChildren().add(buttonRoot);
        mainStage.show();
    }
}

