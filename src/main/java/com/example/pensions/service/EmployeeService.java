package com.example.pensions.service;

import com.example.pensions.model.Employee;
import com.example.pensions.util.Quarters;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> allSorted(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator
                        .comparing(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());
    }

    public List<Employee> upcomingNextQuarter(List<Employee> employees, LocalDate today) {
        LocalDate qStart = Quarters.firstDayOfNextQuarter(today);
        LocalDate qEnd   = Quarters.lastDayOfNextQuarter(today);

        return employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e -> {
                    LocalDate threeYearAnniv = e.getEmploymentDate().plusYears(3);
                    return !(threeYearAnniv.isBefore(qStart) || threeYearAnniv.isAfter(qEnd));
                })
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());
    }
}
