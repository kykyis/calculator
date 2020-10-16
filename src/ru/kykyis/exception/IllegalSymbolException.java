package ru.kykyis.exception;

public class IllegalSymbolException extends Exception {
    public IllegalSymbolException(String message) {
        super("Недопустимый символ или его расположение: '" + message + "' .");
    }
}
