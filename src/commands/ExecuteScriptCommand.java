package commands;

import java.util.Scanner;

/**
 * Команда execute_script: запрашивает файл и передаёт его исполнение ScriptExecutor.
 */
public class ExecuteScriptCommand implements Command {

    @Override
    public void execute() {
        System.out.print("Введите имя файла скрипта: ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine().trim();
        ScriptExecutor.execute(fileName);
    }
}




