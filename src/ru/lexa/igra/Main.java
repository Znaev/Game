package ru.lexa.igra;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Button btnDoor = new Button(" ");
    private Button btnKey = new Button(" ");
    private Button btnForest = new Button(" ");
    private Button btnDungeon = new Button(" ");
    private Button btnBack = new Button("Вернуться");
    private Label stat_health = new Label("Здоровье:");
    private Label stat_stamina = new Label("Выносливость:");
    private Label stat_gold = new Label("Золото:");
    private Label stat_name = new Label("Имя:");

    @Override
    public void start(final Stage primaryStage) {
        FlowPane characterStats = new FlowPane(Orientation.VERTICAL, stat_name, stat_health, stat_stamina, stat_gold);
        GridPane buttonRoot = new GridPane();
        FlowPane mainRoot = new FlowPane(Orientation.VERTICAL, characterStats, buttonRoot);
        buttonRoot.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Игра");
        double width = 300;
        double height = width * 1.5;
        Scene mainScene = new Scene(mainRoot, width, height);
        primaryStage.setScene(mainScene);
        //final Stage SecondWindow = new Stage();
        //SecondWindow.setTitle("Второе Окно");
        //SecondWindow.initModality(Modality.WINDOW_MODAL);
        //SecondWindow.initOwner(primaryStage);
        //SecondWindow.setY(primaryStage.getY()+ 100);


        btnBack.setOnAction(ae -> primaryStage.setScene(mainScene));

        btnDoor.setOnAction(ae -> {
            //Label door = new Label("Это дверь");
            //BorderPane doorRoot = new BorderPane(door);
            //doorRoot.setBottom(btnBack);
            //BorderPane.setAlignment(btnBack, Pos.CENTER);
            //Scene doorScene = new Scene(doorRoot, 200, 150);
            //primaryStage.setScene(doorScene);
            btnDoor.setText("Дверь");
        });
        btnKey.setOnAction(ae -> {
            //Label key = new Label("Это ключ");
            //BorderPane keyRoot = new BorderPane(key);
            //keyRoot.setBottom(btnBack);
            //BorderPane.setAlignment(btnBack, Pos.CENTER);
            //Scene keyScene = new Scene(keyRoot, 200, 150);
            //primaryStage.setScene(keyScene);
            btnKey.setText("Ключ");
        });
        btnForest.setOnAction(ae -> {
            Label forest = new Label("Это лес");
            BorderPane forestRoot = new BorderPane(forest);
            forestRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene forestScene = new Scene(forestRoot, 200, 150);
            primaryStage.setScene(forestScene);
        });
        btnDungeon.setOnAction(ae -> {
            Label dungeon = new Label("Это подземелье");
            BorderPane dungeonRoot = new BorderPane(dungeon);
            dungeonRoot.setBottom(btnBack);
            BorderPane.setAlignment(btnBack, Pos.CENTER);
            Scene dungeonScene = new Scene(dungeonRoot, 200, 150);
            primaryStage.setScene(dungeonScene);
        });
        int buttons_count = 4;
        double button_width = width / Math.sqrt(buttons_count);
        for (int i = 0; i < 2; i++) {
            ColumnConstraints column_button = new ColumnConstraints(button_width, button_width, Double.MAX_VALUE);
            column_button.setHgrow(Priority.ALWAYS);
            buttonRoot.getColumnConstraints().add(column_button);
        }
        double buttons_height = (height / 3) * 2;
        double button_height = buttons_height / Math.sqrt(buttons_count);
        for (int i = 0; i < 2; i++) {
            RowConstraints row_button = new RowConstraints(button_height, button_height, Double.MAX_VALUE);
            row_button.setVgrow(Priority.ALWAYS);
            buttonRoot.getRowConstraints().add(row_button);
        }
        int insetsCount = 5;
        btnKey.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnDoor.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnDungeon.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnForest.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        buttonRoot.setPrefSize(width, button_height);
        buttonRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setMargin(btnKey, new Insets(insetsCount));
        GridPane.setMargin(btnDoor, new Insets(insetsCount));
        GridPane.setMargin(btnDungeon, new Insets(insetsCount));
        GridPane.setMargin(btnForest, new Insets(insetsCount));
        buttonRoot.add(btnKey, 0, 0);
        buttonRoot.add(btnDoor, 1, 1);
        buttonRoot.add(btnDungeon, 0, 1);
        buttonRoot.add(btnForest, 1, 0);
        int stats_count = 4;
        Insets inset_for_stat = new Insets(0, 0, 0, insetsCount);
        double stat_height = ((height - buttons_height) / stats_count) - 1;
        stat_health.setPrefSize(width - insetsCount, stat_height);
        stat_stamina.setPrefSize(width - insetsCount, stat_height);
        stat_gold.setPrefSize(width - insetsCount, stat_height);
        stat_name.setPrefSize(width - insetsCount, stat_height);
        FlowPane.setMargin(stat_health, inset_for_stat);
        FlowPane.setMargin(stat_stamina, inset_for_stat);
        FlowPane.setMargin(stat_gold, inset_for_stat);
        FlowPane.setMargin(stat_name, inset_for_stat);
        characterStats.setMaxSize(width, height - buttons_height);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
