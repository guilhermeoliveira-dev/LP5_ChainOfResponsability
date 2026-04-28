package org.example.model;

public class CfoHandler extends ExpenseHandler{
    public CfoHandler(float approvalLimit) {
        super(approvalLimit);
    }

    @Override
    public String approvalSignature() {
        return "Approved by CFO";
    }


}
