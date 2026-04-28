package org.example.model;

public class TeamHandler extends ExpenseHandler{
    public TeamHandler(float approvalLimit) {
        super(approvalLimit);
    }

    @Override
    public String approvalSignature() {
        return "Approved by Team Leader";
    }


}
