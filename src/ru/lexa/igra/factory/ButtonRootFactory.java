package ru.lexa.igra.factory;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class ButtonRootFactory {
    public static GridPane generateButtonRoot(double width, double height, int insetsCount, ArrayList<Button> buttons) {
        int buttonsCount = buttons.size();
        int sqrtButtons = (int)Math.sqrt(buttonsCount);
        GridPane buttonRoot = new GridPane();
        double buttonWidth = width / sqrtButtons;
        for (int i = 0; i < sqrtButtons; i++) {
            ColumnConstraints columnButton = new ColumnConstraints(buttonWidth, buttonWidth, Double.MAX_VALUE);
            columnButton.setHgrow(Priority.ALWAYS);
            buttonRoot.getColumnConstraints().add(columnButton);
        }
        double buttonsHeight = (height / 3) * 2;
        double buttonHeight = buttonsHeight / sqrtButtons;
        for (int i = 0; i < sqrtButtons; i++) {
            RowConstraints rowButton = new RowConstraints(buttonHeight, buttonHeight, Double.MAX_VALUE);
            rowButton.setVgrow(Priority.ALWAYS);
            buttonRoot.getRowConstraints().add(rowButton);
        }
        for (int i = 0; i < buttonsCount; i++) {
            int indexColumn = i % sqrtButtons;
            int indexRow = i / sqrtButtons;
            buttonRoot.add(buttons.get(i), indexColumn, indexRow);
            GridPane.setMargin(buttons.get(i), new Insets(insetsCount));
        }
        buttonRoot.setPrefSize(width, buttonHeight);
        buttonRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return buttonRoot;
    }
}
