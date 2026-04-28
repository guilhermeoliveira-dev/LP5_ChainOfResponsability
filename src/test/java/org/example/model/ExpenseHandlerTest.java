package org.example.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseHandlerTest {

    private ExpenseHandler teamLeader;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        teamLeader = new TeamHandler(500);
        ExpenseHandler department = new DepartmentHandler(5000);
        ExpenseHandler cfo = new CfoHandler(50000);

        teamLeader.setNextHandler(department);
        department.setNextHandler(cfo);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void givenExpenseUnder500_whenProcessed_thenTeamLeaderApproves() {
        ExpenseReport report = new ExpenseReport("1", 100, "Office Supplies");

        teamLeader.processRequest(report);

        assertTrue(report.wasApproved(),
                "The report should be marked as approved");
        assertTrue(outContent.toString().contains("Approved by Team Leader"),
                "The Team Leader should have signed the approval");
    }

    @Test
    public void givenExpenseUnder5000_whenProcessed_thenDepartmentManagerApproves() {
        ExpenseReport report = new ExpenseReport("2", 750, "Furniture");

        teamLeader.processRequest(report);

        assertTrue(report.wasApproved(),
                "The report should be marked as approved");
        assertTrue(outContent.toString().contains("Approved by Department Manager"),
                "The Department Manager should have signed the approval");
    }

    @Test
    public void givenExpenseUnder50000_whenProcessed_thenCfoApproves() {
        ExpenseReport report = new ExpenseReport("3", 12000, "Office Renovation");

        teamLeader.processRequest(report);

        assertTrue(report.wasApproved(),
                "The report should be marked as approved");
        assertTrue(outContent.toString().contains("Approved by CFO"),
                "The CFO should have signed the approval");
    }

    @Test
    public void givenExpenseOver50000_whenProcessed_thenRequestIsRejected() {
        ExpenseReport report = new ExpenseReport("3", 1000000, "Major Investments");

        teamLeader.processRequest(report);

        assertFalse(report.wasApproved(),
                "The report should NOT be marked as approved");
        assertTrue(outContent.toString().contains("Out of budget"),
                "The system should indicate it is out of budget");
    }
}