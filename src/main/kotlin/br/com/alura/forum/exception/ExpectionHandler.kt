package br.com.alura.forum.exception

import br.com.alura.forum.mapper.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerErrorException


@RestControllerAdvice
class ExpectionHandler {
    @ExceptionHandler(NotFoundException:: class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
        fun handleNotFound(exception: NotFoundException,
                           request: HttpServletRequest
        ): ErrorView {
            return ErrorView(
        status = HttpStatus.NOT_FOUND.value(),
        error = HttpStatus.NOT_FOUND.name,
        message = exception.message,
                path = request.servletPath
            )
    }
    @ExceptionHandler(Exception:: class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(exception: Exception,
                       request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}