package exceptions;

public class IllegalQueryException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Illegal Query Found";
    }
}
