package commands;

import manager.LabWorkTreeSetManager;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        String allElements = LabWorkTreeSetManager.getInstance().getAllElementsAsString();
        System.out.println(allElements);
    }
}
