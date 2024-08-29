package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Этот класс отвечает за управление данными курса и выполнение расчетов, связанных с продолжительностью курса, учетом выходных и праздничных дней, а также дней прокрастинации и работой.

public class CoursePlanner {
    private final LocalDate startDate; // Начальная дата курса
    private final LocalDate endDate; // Конечная дата курса
    private final int plannedDays; // Количество планируемых дней для завершения курса
    private final List<LocalDate> holidays; // Список праздничных дней
    private final long procrastinationDays = 21; // Количество дней прокрастинации
    private final List<LocalDate> workingWeekends; // Список рабочих выходных

    // Конструктор для инициализации данных
    public CoursePlanner(LocalDate startDate, LocalDate endDate, int plannedDays, List<LocalDate> holidays, List<LocalDate> workingWeekends) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.plannedDays = plannedDays;
        this.holidays = holidays;
        this.workingWeekends = workingWeekends;
    }

    // Метод для подсчета общего количества дней
    public long calculateTotalDays() {
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate) + 1;
//      Назначение:
//        Рассчитывает общее количество дней между начальной и конечной датами.
//      Логика:
//        использует метод ChronoUnit.DAYS.between для вычисления количества дней между startDate и endDate.
//                Добавляет 1 к результату, чтобы включить конечную дату в расчет.
    }

    // Метод для подсчета количества выходных и праздничных дней
    public long calculateWeekendsAndHolidays() {
        return DateUtils.countWeekendsAndHolidays(startDate, endDate, holidays, workingWeekends);
//      Назначение:
//        Рассчитывает количество выходных и праздничных дней в заданном диапазоне дат.
//
//      Логика:
//        Вызывает метод countWeekendsAndHolidays из класса DateUtils, передавая ему startDate, endDate, holidays и workingWeekends.
//        Возвращает результат, который представляет количество выходных и праздничных дней в диапазоне.
    }

    // Метод для подсчета количества рабочих дней, потраченных на курс
    public long calculateWorkingDays(long totalDays, long weekendsAndHolidays) {
        return totalDays - weekendsAndHolidays - procrastinationDays;
//      Назначение:
//        Рассчитывает количество рабочих дней, потраченных на курс.
//
//      Логика:
//        Принимает общее количество дней (totalDays) и количество выходных и праздничных дней (weekendsAndHolidays).
//                Вычитает weekendsAndHolidays и procrastinationDays из totalDays.
//                Возвращает результат, который представляет количество рабочих дней, потраченных на курс.
    }

    // Метод для вывода результатов
    public void printResults() {
        long totalDays = calculateTotalDays();
        long weekendsAndHolidays = calculateWeekendsAndHolidays();
        long workingDays = calculateWorkingDays(totalDays, weekendsAndHolidays);
        long discrepancy = totalDays - plannedDays;
        LocalDate plannedEndDate = startDate.plusDays(plannedDays - 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Начало курса: " + startDate);
        System.out.println("Запланировано дней на курс: " + plannedDays);
        System.out.println("Планируемая дата завершения курса: " + plannedEndDate.format(formatter));
        System.out.println("Фактический конец курса: " + endDate);
        System.out.println("Фактическое количество дней на курс: " + totalDays);
        System.out.println("Расхождение дней: " + discrepancy);
        System.out.println("Выходные и праздничные дни: " + weekendsAndHolidays);
        System.out.println("Дни прокрастинации и рабочие дни, когда я не учился: " + procrastinationDays);
        System.out.println("Количество рабочих дней, потраченных на курс: " + workingDays);
        System.out.println("Общее количество дней когда я не учился: " + (weekendsAndHolidays + procrastinationDays) +
                ", или " + String.format("%.1f", (float)(weekendsAndHolidays + procrastinationDays) / 30.44) + " месяцев"); //30.44 среднее количество дней в месяце
//      Назначение:
//        Выводит результаты расчетов на экран.
//
//                Логика:
//        Вызывает методы calculateTotalDays, calculateWeekendsAndHolidays и calculateWorkingDays для получения соответствующих значений.
//        Вычисляет расхождение (discrepancy) между фактическим количеством дней (totalDays) и запланированным количеством дней (plannedDays).
//                Вычисляет планируемую дату завершения курса (plannedEndDate), добавляя plannedDays - 1 к startDate.
//        Форматирует дату завершения курса с использованием DateTimeFormatter.
//                Выводит на экран все рассчитанные значения, включая начальную дату курса, планируемое и фактическое количество дней, расхождение, количество выходных и праздничных дней,
//                количество дней прокрастинации, количество рабочих дней и общее количество дней, когда не было учебы (в днях и месяцах).
    }
}


