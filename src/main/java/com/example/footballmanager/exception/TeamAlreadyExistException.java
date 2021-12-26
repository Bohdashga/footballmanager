package com.example.footballmanager.exception;

public class TeamAlreadyExistException extends Exception{
    public TeamAlreadyExistException(String message) {
        super(message);
    }
}
