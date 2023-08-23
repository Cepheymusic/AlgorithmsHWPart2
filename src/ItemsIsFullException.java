public class ItemsIsFullException extends RuntimeException {
    public ItemsIsFullException() {
    }

    public ItemsIsFullException(String message) {
        super(message);
    }

    public ItemsIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemsIsFullException(Throwable cause) {
        super(cause);
    }

    public ItemsIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
