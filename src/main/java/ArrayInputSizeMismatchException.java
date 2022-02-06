package main.java;

public class ArrayInputSizeMismatchException extends Exception {
    ArrayInputSizeMismatchException() {
        super("Input array has different length!");
    }
}
