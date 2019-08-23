package ru.lexa.igra;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ru.lexa.igra.factory.*;
import ru.lexa.igra.Levels.LevelFirst;

public class Main extends Application {
    private Label stat_health = new Label("Здоровье:");
    private Label stat_stamina = new Label("Выносливость:");
    private Label stat_gold = new Label("Золото:");
    private Label stat_name = new Label("Имя:");
    @Override
    public void start(final Stage primaryStage) {
        LevelFirst.startLevelFirst(primaryStage);
}


    public static void main(String[] args) {
        launch(args);
    }
}
