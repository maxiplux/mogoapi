package api.mongodb.livemarket.business.mogoapi.exceptions;
/**
 * User: franc
 * Date: 09/09/2018
 * Time: 4:21
 */

import api.mongodb.livemarket.business.mogoapi.auth.JwtAuthenticationEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice // To Handle Exceptions
public class ResourceUnauthorizedException {
    //// ...........
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @ExceptionHandler({HttpUnauthorizedException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    Map<String, String> unauthorizedAccess(Exception e) {
        Map<String, String> exception = new HashMap<String, String>();

        logger.error("unauthorized Access to the API: " + e.getMessage(), e);
        exception.put("code", "401");
        exception.put("reason", e.getMessage());

        return exception;
    }
}
