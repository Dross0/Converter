package Converter.units.currency.exceptions;

public class ConnectionException extends Exception {
    private final String errorMessage;

    public ConnectionException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
