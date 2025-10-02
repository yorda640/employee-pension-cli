package com.example.pensions;

import com.example.pensions.data.InMemoryData;
import com.example.pensions.service.EmployeeService;
import com.example.pensions.util.Jsons;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        var employees = InMemoryData.load();
        var svc = new EmployeeService();

        if (args.length == 0) {
            System.out.println("""
                    Usage:
                      list       -> all employees (JSON), salary desc / lastName asc
                      upcoming   -> next-quarter upcoming enrollees (JSON), employmentDate desc

                    Examples:
                      mvn -q -Dexec.mainClass=com.example.pensions.App -Dexec.args='list' exec:java
                      mvn -q -Dexec.mainClass=com.example.pensions.App -Dexec.args='upcoming' exec:java
                    """);
            return;
        }

        switch (args[0]) {
            case "list" -> System.out.println(Jsons.pretty(svc.allSorted(employees)));
            case "upcoming" -> {
                var today = LocalDate.now();
                System.out.println(Jsons.pretty(svc.upcomingNextQuarter(employees, today)));
            }
            default -> System.out.println("Unknown command: " + args[0]);
        }
    }
}
