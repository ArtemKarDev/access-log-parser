import ru.courses.main.Main;

public class OperationAttemptException extends Exception {

    public OperationAttemptException(){
        super();
    }

    public OperationAttemptException(String message){
        super(message);
    }

    public OperationAttemptException(String message, Throwable cause){
        super(message, cause);
    }

    public OperationAttemptException(Throwable cause){
        super(cause);
    }

    public OperationAttemptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression,writableStackTrace);
    }

}
