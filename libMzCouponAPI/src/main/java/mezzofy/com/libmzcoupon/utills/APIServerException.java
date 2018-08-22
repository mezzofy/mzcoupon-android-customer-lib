package mezzofy.com.libmzcoupon.utills;

/**
 * Created by aruna on 2/15/18.
 */

public class APIServerException extends Exception {

    String message;
    String code;
    String developerMessage;


    public APIServerException() {
        super();
    }

    public APIServerException(String message,String code,String developerMessage) {
        super(message);
        this.message = message;
        this.code=code;
        this.developerMessage=developerMessage;
    }

    public APIServerException(Throwable throwable) {
        super(throwable);
    }

    public String getMessage() {
        return message + " - " + code + " - " + developerMessage;
    }
}
