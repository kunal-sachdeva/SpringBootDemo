package com.example.demo.exception;

public class ProductNotfoundException extends RuntimeException{
    public static final long serialVersionUID=1L;
    private String message = "Product Not Found";
    public ProductNotfoundException(String msg){
        super();
        message=msg;
    }
    public ProductNotfoundException( ){
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
