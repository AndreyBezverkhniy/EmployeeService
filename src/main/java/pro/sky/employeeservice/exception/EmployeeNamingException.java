package pro.sky.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeNamingException extends RuntimeException {
    public EmployeeNamingException() {
    }

    public EmployeeNamingException(String message) {
        super(message);
    }

    public EmployeeNamingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNamingException(Throwable cause) {
        super(cause);
    }

    public EmployeeNamingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
