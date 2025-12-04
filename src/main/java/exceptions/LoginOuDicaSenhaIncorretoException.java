package exceptions;

public class LoginOuDicaSenhaIncorretoException extends RuntimeException {
    public LoginOuDicaSenhaIncorretoException(String message) {
        super(message);
    }
}
