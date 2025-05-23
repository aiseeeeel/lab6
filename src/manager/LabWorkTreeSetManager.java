package manager;

import model.LabWork; // Предполагается, что LabWork реализует Comparable
import model.Person;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LabWorkTreeSetManager {
    private static LabWorkTreeSetManager instance;
    private TreeSet<LabWork> labWorks;
    private LocalDateTime initializationTime;

    // Приватный конструктор для реализации singleton
    private LabWorkTreeSetManager() {
        this.labWorks = new TreeSet<>();
        this.initializationTime = LocalDateTime.now();
    }

    // Глобальная точка доступа к экземпляру
    public static synchronized LabWorkTreeSetManager getInstance() {
        if (instance == null) {
            instance = new LabWorkTreeSetManager();
        }
        return instance;
    }

    public TreeSet<LabWork> getAllElements() {
        return labWorks;
    }


    // Метод для получения информации о коллекции
    public String getCollectionInfo() {
        return "Тип коллекции: " + labWorks.getClass().getName() + "\n" +
                "Дата инициализации: " + initializationTime + "\n" +
                "Количество элементов: " + labWorks.size();
    }


    // Метод для получения строкового представления всех элементов коллекции
    public String getAllElementsAsString() {
        if (labWorks.isEmpty()) {
            return "Коллекция пуста.";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<LabWork> iterator = labWorks.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    // Добавление нового элемента в коллекцию
    public boolean add(LabWork element) {
        return labWorks.add(element);
    }

    // Обновление элемента с указанным id: безопасное удаление старого элемента и добавление нового (с сохранённым id)
    public boolean updateById(long id, LabWork newElement) {
        Iterator<LabWork> iterator = labWorks.iterator();
        while (iterator.hasNext()) {
            LabWork lw = iterator.next();
            if (lw.getId() == id) {
                iterator.remove();
                newElement.setId(id);
                labWorks.add(newElement);
                return true;
            }
        }
        return false;
    }

    public boolean containsId(long id) {
        return labWorks.stream().anyMatch(lw -> lw.getId() == id);
    }

    // Удаление элемента по id
    public boolean removeById(long id) {
        return labWorks.removeIf(lw -> lw.getId() == id);
    }

    // Очистка всей коллекции
    public void clear() {
        labWorks.clear();
    }

    // Добавление элемента, если он больше наибольшего элемента текущей коллекции
    public boolean addIfMax(LabWork element) {
        if (labWorks.isEmpty()) {
            labWorks.add(element);
            return true;
        }
        LabWork max = labWorks.last(); // последний элемент — максимальный (TreeSet отсортирован)
        if (element.compareTo(max) > 0) {
            labWorks.add(element);
            return true;
        }
        return false;
    }

    // Удаление всех элементов, меньших заданного (возвращает количество удалённых элементов)
    public int removeLower(LabWork element) {
        int initialSize = labWorks.size();
        labWorks.removeIf(lw -> lw.compareTo(element) < 0);
        return initialSize - labWorks.size();
    }

    // Фильтрация элементов, у которых значение поля minimalPoint меньше заданного
    public List<LabWork> filterLessThanMinimalPoint(double minimalPoint) {
        return labWorks.stream()
                .filter(lw -> lw.getMinimalPoint() < minimalPoint)
                .collect(Collectors.toList());
    }

    // Метод для получения элементов в порядке убывания
    public String getElementsDescending() {
        if (labWorks.isEmpty()) {
            return "Коллекция пуста.";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<LabWork> iterator = labWorks.descendingSet().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }


    // Получение уникальных значений поля author у всех элементов коллекции
    public Set<String> getUniqueAuthors() {
        return labWorks.stream()
                .map(LabWork::getAuthor)
                .filter(Objects::nonNull)
                .map(Person::getName) // преобразуем Person в String
                .collect(Collectors.toSet());
    }



}
