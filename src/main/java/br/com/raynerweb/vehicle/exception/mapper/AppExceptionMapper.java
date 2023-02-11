package br.com.raynerweb.vehicle.exception.mapper;

import br.com.raynerweb.vehicle.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionMapper {

    private static final String TIMESTAMP = "timestamp";
    private static final String STATUS = "status";
    private static final String ERROR = "error";
    private static final String MESSAGE = "message";
    private static final String PATH = "path";


    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> handle(DataIntegrityViolationException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.CONFLICT, request.getRequestURI(), ex.getMessage());
    }
    /**
     * UnauthorizedException is thrown when the JWT is invalid or expired.
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> handle(UnauthorizedException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.UNAUTHORIZED, request.getRequestURI(), ex.getMessage());
    }

    /**
     * ForbiddenException is thrown when the client has a valid credential but does not have permition to proced.
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, Object> handle(ForbiddenException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.FORBIDDEN, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handle(BadRequestException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.BAD_REQUEST, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handle(NotFoundException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.NOT_FOUND, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handle(InternalServerErrorException ex, HttpServletRequest request) {
        return getErroHttp(HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI(), ex.getMessage());
    }

    public Map<String, Object> getErroHttp(HttpStatus httpStatus, String requestURI, String mensagem) {
        Map<String, Object> erro = new HashMap<>();
        erro.put(TIMESTAMP, new Date());
        erro.put(STATUS, httpStatus.value());
        erro.put(ERROR, httpStatus.getReasonPhrase());
        erro.put(MESSAGE, mensagem);
        erro.put(PATH, requestURI);
        return erro;
    }

}
