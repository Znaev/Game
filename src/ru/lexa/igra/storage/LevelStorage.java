package ru.lexa.igra.storage;


import javafx.scene.control.Button;

public class LevelStorage {
    private Button door;
    private Button key;

    public Button getDoor() {
        return door;
    }

    public void setDoor(Button door) {
        this.door = door;
    }

    public Button getKey() {
        return key;
    }

    public void setKey(Button key) {
        this.key = key;
    }
}
