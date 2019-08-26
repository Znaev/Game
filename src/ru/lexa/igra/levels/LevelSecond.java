package ru.lexa.igra.levels;

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

public class LevelSecond {
    static public void startLevelSecond(Stage mainStage) {
        Label statHealth = new Label("Здоровье:");
        Label statStamina = new Label("Выносливость:");
        Label statGold = new Label("Золото:");
        Label statName = new Label("Имя:");
        double width = 300;
        double height = width * 1.5;
        int insetsCount = 5;
        int buttonsCount = 9;
        FlowPane characterStats = FlowPaneFactory.generateFlowPane(width, height, insetsCount,
                statName, statHealth, statStamina, statGold);
        FlowPane mainRoot = new FlowPane(Orientation.VERTICAL, characterStats);
        mainStage.setTitle("Игра");
        Scene mainScene = new Scene(mainRoot, width, height);
        mainStage.setScene(mainScene);
        ArrayList<Button> buttons = ButtonFactory.secondGenerateButtons(buttonsCount, mainStage, mainScene);
        GridPane buttonRoot = ButtonRootFactory.generateButtonRoot(width, height, insetsCount, buttons);
        mainRoot.getChildren().add(buttonRoot);
        mainStage.show();
    }


}
