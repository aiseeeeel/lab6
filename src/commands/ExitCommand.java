package commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Выход из программы...");
    }
}
