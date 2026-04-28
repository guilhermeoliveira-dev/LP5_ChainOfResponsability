package org.example.model;

public class DepartmentHandler extends ExpenseHandler{
    public DepartmentHandler(float approvalLimit) {
        super(approvalLimit);
    }

    @Override
    public String approvalSignature() {
        return "Approved by Department Manager";
    }


}
