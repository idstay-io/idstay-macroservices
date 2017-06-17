package io.idstay.prs.interfaces;

public class HousekeepingNotFoundException extends RuntimeException {
    public HousekeepingNotFoundException(String message) {
        super(message);
    }
}
