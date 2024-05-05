package com.operpagos.apicriptobaz.exception;

public class DecryptException extends RuntimeException{
    public DecryptException(String message) {
        super("Error in encrypt method: " + message);
    }
}
