package ru.telda.demo.exception;

public class RegionNotFoundException extends RuntimeException {
    public RegionNotFoundException(Exception ex) {
        super(ex);
    }

    public RegionNotFoundException(String message) {
        super(message);
    }
}
