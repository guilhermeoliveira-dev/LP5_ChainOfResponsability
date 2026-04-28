package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {

        ExpenseHandler teamLeader = new TeamHandler(500);
        ExpenseHandler department = new DepartmentHandler(5000);
        ExpenseHandler cfo = new CfoHandler(50000);

        teamLeader.setNextHandler(department);
        department.setNextHandler(cfo);

        System.out.println();

        ExpenseReport report = new ExpenseReport("1", 100, "Office Supplies");
        teamLeader.processRequest(report);
        System.out.println(report.wasApproved());

        System.out.println();

        ExpenseReport report2= new ExpenseReport("2", 750, "Furniture");
        teamLeader.processRequest(report2);
        System.out.println(report2.wasApproved());

        System.out.println();

        ExpenseReport report3 = new ExpenseReport("3", 12000, "Office Renovation");
        teamLeader.processRequest(report3);
        System.out.println(report3.wasApproved());

        System.out.println();

        ExpenseReport report4 = new ExpenseReport("3", 1000000, "Major Investments");
        teamLeader.processRequest(report4);
        System.out.println(report4.wasApproved());

    }
}