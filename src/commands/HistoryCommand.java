package commands;

import static commands.CommandHistory.MAX_HISTORY_SIZE;

public class HistoryCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Последние " + MAX_HISTORY_SIZE + " команд:");
        CommandHistory.getHistory().forEach(System.out::println);
    }
}
