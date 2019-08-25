package pl.sda.springmvc.springmvcDemo.exception;

public class NotFoundUserException extends WebApplicationException {
    public NotFoundUserException(String message) {
        super(message);
    }
}
