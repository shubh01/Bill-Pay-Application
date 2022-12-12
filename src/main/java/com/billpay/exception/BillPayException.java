package com.billpay.exception;

public class BillPayException extends RuntimeException{

    private String errorMessage;

    public BillPayException(){
        super();
    }

    public BillPayException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BillPayException(String errorMessage, Throwable throwable) {
        super(errorMessage,throwable);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
