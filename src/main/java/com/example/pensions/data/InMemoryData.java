package com.example.pensions.data;

import com.example.pensions.model.Employee;
import com.example.pensions.model.PensionPlan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class InMemoryData {

    public static List<Employee> load() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1L, "Daniel", "Agar",
                LocalDate.of(2023, 1, 17),
                new BigDecimal("105945.50"))
                .withPension(new PensionPlan("EX1089", LocalDate.of(2023,1,17), new BigDecimal("100.00"))));

        list.add(new Employee(2L, "Benard", "Shaw",
                LocalDate.of(2022, 9, 3),
                new BigDecimal("197750.00"))
                .withPension(new PensionPlan("PLN-2025-09-03", LocalDate.of(2025,9,3), null)));

        list.add(new Employee(3L, "Carly", "Agar",
                LocalDate.of(2014, 5, 16),
                new BigDecimal("842000.75"))
                .withPension(new PensionPlan("SM2307", LocalDate.of(2017,5,17), new BigDecimal("1555.50"))));

        list.add(new Employee(4L, "Wesley", "Schneider",
                LocalDate.of(2023, 7, 21),
                new BigDecimal("74500.00")));

        list.add(new Employee(5L, "Anna", "Wiltord",
                LocalDate.of(2023, 3, 15),
                new BigDecimal("85750.00")));

        list.add(new Employee(6L, "Yosef", "Tesfalem",
                LocalDate.of(2024, 10, 31),
                new BigDecimal("100000.00")));

        return list;
    }
}
