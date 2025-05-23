package commands;

import manager.LabWorkTreeSetManager;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        String info = LabWorkTreeSetManager.getInstance().getCollectionInfo();
        System.out.println(info);
    }
}

