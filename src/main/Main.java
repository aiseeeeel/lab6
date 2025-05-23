package main;

import manager.LabWorkTreeSetManager;

public class
Main {
    public static void main(String[] args) {
        LabWorkTreeSetManager manager = LabWorkTreeSetManager.getInstance();
        new manager.XmlCollectionLoader(manager, "collection.txt").load();
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }
}
