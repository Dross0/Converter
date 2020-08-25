package Converter.units.currency.exceptions;

public class ClientConnectionException extends Exception {
    private final String errorMessage;

    public ClientConnectionException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
