package br.com.victsoft.simples.config.exceptions;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final transient Object[] params;

    public ServiceException(String message, Object... params) {
        this.message = message;
        this.params = params;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object[] getParams() {
        return params;
    }
}
