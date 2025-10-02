package com.example.pensions.util;

import java.time.LocalDate;
import java.time.YearMonth;

public final class Quarters {

    public static LocalDate firstDayOfNextQuarter(LocalDate today) {
        int m = today.getMonthValue();
        int nextQStartMonth = (((m - 1) / 3) * 3 + 4);
        if (nextQStartMonth > 12) nextQStartMonth -= 12;
        int year = today.getYear() + ((today.getMonthValue() >= 10) ? 1 : 0);
        if (nextQStartMonth == 1) year = today.getMonthValue() >= 10 ? today.getYear() + 1 : today.getYear();
        return LocalDate.of(year, nextQStartMonth, 1);
    }

    public static LocalDate lastDayOfNextQuarter(LocalDate today) {
        LocalDate start = firstDayOfNextQuarter(today);
        YearMonth ym = YearMonth.of(start.getYear(), start.getMonth()).plusMonths(2);
        return ym.atEndOfMonth();
    }
}
