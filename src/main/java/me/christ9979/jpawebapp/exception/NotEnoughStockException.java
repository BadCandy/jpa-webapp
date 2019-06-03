package me.christ9979.jpawebapp.exception;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String s) {
        super(s);
    }
}
