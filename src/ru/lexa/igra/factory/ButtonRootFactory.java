package ru.lexa.igra.factory;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class ButtonRootFactory {
    public static GridPane generateButtonRoot(double width, double height, int buttonsCount, int insetsCount, ArrayList<Button> buttons) {
        GridPane buttonRoot = new GridPane();
        double button_width = width / Math.sqrt(buttonsCount);
        for (int i = 0; i < Math.sqrt(buttonsCount); i++) {
            ColumnConstraints column_button = new ColumnConstraints(button_width, button_width, Double.MAX_VALUE);
            column_button.setHgrow(Priority.ALWAYS);
            buttonRoot.getColumnConstraints().add(column_button);
        }
        double buttons_height = (height / 3) * 2;
        double button_height = buttons_height / Math.sqrt(buttonsCount);
        for (int i = 0; i < Math.sqrt(buttonsCount); i++) {
            RowConstraints row_button = new RowConstraints(button_height, button_height, Double.MAX_VALUE);
            row_button.setVgrow(Priority.ALWAYS);
            buttonRoot.getRowConstraints().add(row_button);
        }
        for (int i = 0; i < buttonsCount; i++) {
            int indexColumn = i % (int) Math.sqrt(buttonsCount);
            int indexRow = i / (int) Math.sqrt(buttonsCount);
            buttonRoot.add(buttons.get(i), indexColumn, indexRow);
            GridPane.setMargin(buttons.get(i), new Insets(insetsCount));
        }
        buttonRoot.setPrefSize(width, button_height);
        buttonRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return buttonRoot;
    }
}
