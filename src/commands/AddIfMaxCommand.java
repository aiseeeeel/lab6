package commands;

import manager.LabWorkTreeSetManager;
import model.LabWork;
import java.util.Scanner;

public class AddIfMaxCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные нового элемента для проверки на максимальность:");

        // Используем вспомогательный класс для ввода всех данных нового LabWork
        LabWork labWork = LabWorkInputHelper.readLabWork(scanner);

        // Если новый элемент больше максимального в коллекции, он будет добавлен.
        if (LabWorkTreeSetManager.getInstance().addIfMax(labWork)) {
            System.out.println("Элемент добавлен, так как он максимальный.");
        } else {
            System.out.println("Элемент не является максимальным, добавление не выполнено.");
        }
    }
}

