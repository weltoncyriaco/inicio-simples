package br.com.victsoft.simples.config.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {
//    TODO: descomentar em caso de querer que algum tipo de erro serja impresso no log.
//    private static final Logger log = LogManager.getLogger(ApplicationErrorHandler.class);

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException ex, WebRequest request){
        return handleExceptionInternal(ex, new Error(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    public static class Error {

        private final boolean serviceError;

        private final boolean validationError;

        private final String message;

        private final List<ValidationError> validationErrors;

        public Error(String message) {
            this.serviceError = true;
            this.message = message;
            this.validationError = false;
            this.validationErrors = null;
        }

        public Error(List<ValidationError> validationErrors) {
            this.serviceError = false;
            this.validationError = true;
            this.message = null;
            this.validationErrors = validationErrors;
        }

        public boolean isServiceError() {
            return serviceError;
        }

        public boolean isValidationError() {
            return validationError;
        }

        public String getMessage() {
            return message;
        }

        public List<ValidationError> getValidationErrors() {
            return validationErrors;
        }
    }

    public static class ValidationError {

        private final String field;

        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}
