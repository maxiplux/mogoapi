package api.mongodb.livemarket.business.mogoapi.exceptions;
/**
 * User: franc
 * Date: 09/09/2018
 * Time: 4:21
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class HttpUnauthorizedException extends RuntimeException {
    public HttpUnauthorizedException(String message) {
        super(message);
    }

    public HttpUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
