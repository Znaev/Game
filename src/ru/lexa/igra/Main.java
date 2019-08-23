package ru.lexa.igra;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.lexa.igra.Levels.LevelFirst;

public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) {
        LevelFirst.startLevelFirst(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
