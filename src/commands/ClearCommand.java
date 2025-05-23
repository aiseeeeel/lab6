package commands;

import manager.LabWorkTreeSetManager;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        LabWorkTreeSetManager.getInstance().clear();
        System.out.println("Коллекция очищена.");
    }
}
