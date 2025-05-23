package commands;

import manager.LabWorkTreeSetManager;

public class PrintDescendingCommand implements Command {
    @Override
    public void execute() {
        String descending = LabWorkTreeSetManager.getInstance().getElementsDescending();
        System.out.println(descending);
    }
}

