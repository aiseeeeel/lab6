package commands;

import manager.LabWorkTreeSetManager;
import java.util.Set;

public class PrintUniqueAuthorCommand implements Command {
    @Override
    public void execute() {
        Set<String> uniqueAuthors = LabWorkTreeSetManager.getInstance().getUniqueAuthors();
        if (uniqueAuthors.isEmpty()) {
            System.out.println("Нет уникальных авторов.");
        } else {
            uniqueAuthors.forEach(System.out::println);
        }
    }
}

