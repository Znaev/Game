package ru.lexa.igra.factory;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class FlowPaneFactory {
    public static FlowPane generateFlowPane(double width, double height, double insets, Label... stats) {
        FlowPane outPane = new FlowPane(Orientation.VERTICAL);
        int stats_count = stats.length;
        Insets inset_for_stat = new Insets(0, 0, 0, insets);
        double stat_height = ((height / 3) / stats_count) - 1;
        for (Label stat : stats) {
            stat.setPrefSize(width - insets, stat_height);
            FlowPane.setMargin(stat, inset_for_stat);
            outPane.getChildren().add(stat);
        }
        outPane.setMaxSize(width, height / 3);
        return outPane;
    }
}