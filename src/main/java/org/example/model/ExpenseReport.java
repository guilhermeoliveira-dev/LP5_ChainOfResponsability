package org.example.model;

public class ExpenseReport {

    private final String employeeId;
    private final float amount;
    private final String description;
    private boolean approved;

    public ExpenseReport(String employeeId, float amount, String description){
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
        this.approved = false;
    }

    public void approve(){
        approved = true;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public boolean wasApproved(){
        return approved;
    }
}
