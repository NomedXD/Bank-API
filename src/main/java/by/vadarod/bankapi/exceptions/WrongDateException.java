package by.vadarod.bankapi.exceptions;

public class WrongDateException extends IllegalArgumentException {
    public WrongDateException() {
        super("The date provided is greater than today's");
    }
}
