package jar.us.springbootrfc7807

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientFundsException::class)
    fun handleInsufficientFunds(
        ex: InsufficientFundsException,
        request: HttpServletRequest
    ): ResponseEntity<ProblemDetails> {

        val problemDetails = ProblemDetails(
            type = "https://example.com/probs/insufficient-funds",
            title = "Insufficient Funds",
            status = HttpStatus.FORBIDDEN.value(),
            detail = ex.detail,
            instance = request.requestURI
        )

        return ResponseEntity(problemDetails, HttpStatus.FORBIDDEN)
    }
}