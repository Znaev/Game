package ru.lexa.igra.storage;


import javafx.scene.control.Button;

public class LevelStorage {
    private static LevelStorage instance;

    private LevelStorage() {
    }

    public static LevelStorage getInstance() {
        if (instance == null) {
            instance = new LevelStorage();
        }
        return instance;
    }

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
