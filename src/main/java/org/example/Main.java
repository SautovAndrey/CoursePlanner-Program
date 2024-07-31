package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Входные данные
        // Метод main является точкой входа в программу. Он инициализирует данные, необходимые для выполнения расчетов,
        // создает экземпляр CoursePlanner и запускает метод printResults.

        LocalDate startDate = LocalDate.parse("2024-02-02"); // startDate: Начальная дата курса, создается с использованием метода parse класса LocalDate.
        LocalDate endDate = LocalDate.parse("2024-07-18"); // endDate: Конечная дата курса, создается аналогично.
        int plannedDays = 90; // plannedDays: Количество запланированных дней для завершения курса.

        // Создание экземпляра CoursePlanner и выполнение расчетов
        CoursePlanner planner = getCoursePlanner(startDate, endDate, plannedDays);
        planner.printResults();
    }

    private static CoursePlanner getCoursePlanner(LocalDate startDate, LocalDate endDate, int plannedDays) {
    // Список праздничных дней
//        getCoursePlanner: Метод для создания и инициализации экземпляра CoursePlanner.
//      Параметры:
//        LocalDate startDate: Начальная дата курса.
//        LocalDate endDate: Конечная дата курса.
//        int plannedDays: Количество запланированных дней для завершения курса.
//        Возвращаемое значение: Новый экземпляр CoursePlanner с инициализированными данными.
//
//      Логика:
//        Создает список праздничных дней (holidays) с использованием метода List.of и LocalDate.parse для каждой даты.
//        Создает список рабочих выходных (workingWeekends) аналогично списку праздничных дней.
//                Возвращает новый экземпляр CoursePlanner, передавая все инициализированные данные в его конструктор.
        List<LocalDate> holidays = List.of(
                LocalDate.parse("2024-02-23"),
                LocalDate.parse("2024-03-08"),
                LocalDate.parse("2024-04-29"),
                LocalDate.parse("2024-04-30"),
                LocalDate.parse("2024-05-01"),
                LocalDate.parse("2024-05-09"),
                LocalDate.parse("2024-05-10"),
                LocalDate.parse("2024-06-12")
        );

        // Список рабочих выходных
        List<LocalDate> workingWeekends = List.of(
                LocalDate.parse("2024-04-27")
        );

        // Возвращает новый экземпляр CoursePlanner с инициализированными данными
        return new CoursePlanner(startDate, endDate, plannedDays, holidays, workingWeekends);
    }
}
