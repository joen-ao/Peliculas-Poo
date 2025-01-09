package exceptions;

public class ErrorDuracionException extends RuntimeException{

    private String message;

    public ErrorDuracionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
