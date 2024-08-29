package org.example;

import java.time.LocalDate;
import java.util.List;

//Программа состоит из трех классов:
//
//Main - точка входа в приложение, инициализация данных и запуск расчетов.
//CoursePlanner - класс, выполняющий основные расчеты, связанные с продолжительностью курса.
//DateUtils - вспомогательный класс для работы с датами, включая проверку выходных и праздничных дней.

public class Main {
    public static void main(String[] args) {
        // Входные данные
        // Метод main является точкой входа в программу.
        // Здесь мы создаем объект CoursePlanner, который управляет данными курса и выполняет необходимые расчеты.
        // Создание объекта CoursePlanner с указанием начальной даты, конечной даты и количества запланированных дней.
        CoursePlanner planner = getCoursePlanner(
                LocalDate.parse("2024-02-02"),  // Дата начала курса
                LocalDate.parse("2024-07-18")  // Дата окончания курса
        );

        // Вывод результатов расчета курса на экран.
        // Метод printResults выводит на экран все важные параметры и расчеты, связанные с курсом.
        planner.printResults();
    }

    private static CoursePlanner getCoursePlanner(LocalDate startDate, LocalDate endDate) {
    // Список праздничных дней
//        getCoursePlanner: Метод для создания и инициализации экземпляра CoursePlanner.
//      Параметры:
//        LocalDate startDate: Начальная дата курса.
//        LocalDate endDate: Конечная дата курса.
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
        return new CoursePlanner(startDate, endDate, 90, holidays, workingWeekends);
    }
}
