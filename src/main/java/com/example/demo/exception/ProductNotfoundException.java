package com.example.demo.exception;

public class ProductNotfoundException extends RuntimeException{
    public static final long serialVersionUID=1L;
    public String message = "Product Not Found";

    @Override
    public String getMessage() {
        return message;
    }
}
