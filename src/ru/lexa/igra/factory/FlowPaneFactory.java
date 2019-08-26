package ru.lexa.igra.factory;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class FlowPaneFactory {
    public static FlowPane generateFlowPane(double width, double height, double insets, Label... stats) {
        FlowPane outPane = new FlowPane(Orientation.VERTICAL);
        int statsCount = stats.length;
        Insets insetForStat = new Insets(0, 0, 0, insets);
        double statHeight = ((height / 3) / statsCount) - 1;
        for (Label stat : stats) {
            stat.setPrefSize(width - insets, statHeight);
            FlowPane.setMargin(stat, insetForStat);
            outPane.getChildren().add(stat);
        }
        outPane.setMaxSize(width, height / 3);
        return outPane;
    }
}