package org.example.model;

public abstract class ExpenseHandler {

    private ExpenseHandler nextHandler;
    private float approvalLimit;

    public ExpenseHandler(float approvalLimit){
        this.approvalLimit = approvalLimit;
    }

    public void setNextHandler(ExpenseHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void processRequest(ExpenseReport request){
        if(request.getAmount() <= approvalLimit){
            request.approve();
            System.out.println("Request: \""+request.getDescription()+"\" for $"+request.getAmount());
            System.out.println(approvalSignature());
        }
        else{
            if(nextHandler != null){
                nextHandler.processRequest(request);
            }
            else{
                System.out.println("Out of budget");
            }
        }
    }

    public abstract String approvalSignature();

}
