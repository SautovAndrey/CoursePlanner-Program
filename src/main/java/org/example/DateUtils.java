package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.threeten.extra.LocalDateRange;

// Этот класс предоставляет утилитарные методы для работы с датами, в частности, для проверки, является ли дата выходным или праздничным днем,
// а также для подсчета количества таких дней в заданном диапазоне.
public class DateUtils {

    // Метод для проверки, является ли дата выходным днем (суббота или воскресенье)
    public static boolean isWeekend(LocalDate date, List<LocalDate> workingWeekends) {
        DayOfWeek day = date.getDayOfWeek();
        // Возвращает true, если дата является субботой или воскресеньем, и не входит в список рабочих выходных
        return ((day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) && !workingWeekends.contains(date));
//      Назначение:
//        Проверяет, является ли заданная дата выходным днем (суббота или воскресенье).
//
//      Параметры:
//        LocalDate date: Дата, которую нужно проверить.
//        List<LocalDate> workingWeekends: Список выходных дней, которые считаются рабочими.

//      Логика:
//        Получает день недели для заданной даты с помощью date.getDayOfWeek().
//                Проверяет, является ли день недели субботой (DayOfWeek.SATURDAY) или воскресеньем (DayOfWeek.SUNDAY).
//                Дополнительно проверяет, содержится ли дата в списке рабочих выходных.
//        Возвращает true, если дата является субботой или воскресеньем и не входит в список рабочих выходных, иначе возвращает false.
    }


    // Метод для проверки, является ли дата праздничным днем
    public static boolean isHoliday(LocalDate date, List<LocalDate> holidays) {
        // Возвращает true, если дата содержится в списке праздничных дней
        return holidays.contains(date);
//      Назначение:
//        Проверяет, является ли заданная дата праздничным днем.
//
//      Параметры:
//        LocalDate date: Дата, которую нужно проверить.
//        List<LocalDate> holidays: Список праздничных дней.
//
//      Логика:
//        Проверяет, содержится ли заданная дата в списке праздничных дней (holidays.contains(date)).
//                Возвращает true, если дата содержится в списке, иначе возвращает false.
    }

    // Метод для подсчета количества выходных и праздничных дней в заданном диапазоне
    public static long countWeekendsAndHolidays(LocalDate startDate, LocalDate endDate, List<LocalDate> holidays, List<LocalDate> workingWeekends) {
        // Создает диапазон дат от startDate до endDate
        LocalDateRange range = LocalDateRange.of(startDate, endDate);
        // Возвращает количество дат в диапазоне, которые являются либо выходными, либо праздничными днями
        return range.stream()
                .filter(date -> isWeekend(date, workingWeekends) || isHoliday(date, holidays))
                .count();
//      Назначение:
//        Подсчитывает количество выходных и праздничных дней в заданном диапазоне дат.
//
//      Параметры:
//        LocalDate startDate: Начальная дата диапазона.
//                LocalDate endDate: Конечная дата диапазона.
//                List<LocalDate> holidays: Список праздничных дней.
//                List<LocalDate> workingWeekends: Список рабочих выходных.
//
//      Логика:
//        Создает диапазон дат от startDate до endDate включительно с помощью LocalDateRange.of(startDate, endDate).
//                Применяет потоковую обработку (range.stream()) для перебора всех дат в диапазоне.
//        Фильтрует даты, которые являются либо выходными (используя метод isWeekend), либо праздничными (используя метод isHoliday).
//                Считает количество таких дат с помощью метода count()
    }
}