package br.com.fmatheus.app.controller.exception.handler

import br.com.fmatheus.app.controller.exception.BadRequestException
import org.springframework.context.MessageSource
import org.springframework.context.NoSuchMessageException
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.*
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.lang.NonNull
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApiExceptionHandler(private val messageSource: MessageSource) : ResponseEntityExceptionHandler() {

    companion object {
        private const val UNEXPECTED_ERROR = "Ocorreu um erro inesperado."
        private const val MESSAGE = "message"
    }

    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        @NonNull headers: HttpHeaders,
        @NonNull status: HttpStatusCode,
        @NonNull request: WebRequest
    ): ResponseEntity<Any> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, "O corpo da requisição está inválido ou mal formatado.")
        problemDetail.setProperty("message", ex.mostSpecificCause?.message ?: "Erro desconhecido")
        return ResponseEntity.status(httpStatus).body(problemDetail)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        @NonNull headers: HttpHeaders,
        @NonNull status: HttpStatusCode,
        @NonNull request: WebRequest
    ): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors.map {
            "Campo '${it.field}': ${it.defaultMessage}"
        }

        val httpStatus = HttpStatus.BAD_REQUEST
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, "Erro de validação nos campos fornecidos.")
        problemDetail.setProperty("errors", errors)
        return ResponseEntity.status(httpStatus).body(problemDetail)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleTypeMismatch(ex: MethodArgumentTypeMismatchException): ResponseEntity<ProblemDetail> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, "Tipo de argumento inválido.")
        problemDetail.setProperty("parameter", ex.name)
        problemDetail.setProperty("expectedType", ex.requiredType?.simpleName ?: "desconhecido")
        return ResponseEntity.status(httpStatus).body(problemDetail)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<ProblemDetail> {
        val httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, UNEXPECTED_ERROR)
        problemDetail.setProperty(MESSAGE, ex.message ?: "Erro desconhecido")
        return ResponseEntity.status(httpStatus).body(problemDetail)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: Exception): ResponseEntity<ProblemDetail> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, UNEXPECTED_ERROR)
        problemDetail.setProperty(MESSAGE, returnMessage(ex))
        return ResponseEntity.status(httpStatus).body(problemDetail)
    }


    private fun returnMessage(ex: Exception): String {
        return try {
            messageSource.getMessage(ex.message ?: "", null, LocaleContextHolder.getLocale())
        } catch (e: NoSuchMessageException) {
            ex.message ?: "Erro desconhecido"
        }
    }
}