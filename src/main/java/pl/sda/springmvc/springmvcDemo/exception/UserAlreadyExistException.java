package pl.sda.springmvc.springmvcDemo.exception;

public class UserAlreadyExistException extends WebApplicationException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
