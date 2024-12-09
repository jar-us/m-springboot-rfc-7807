package jar.us.springbootrfc7807

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController {

    @PostMapping("/transfer")
    fun transferMoney(@RequestBody request: TransferRequest): ResponseEntity<String> {
        if (request.amount > request.balance) {
            throw InsufficientFundsException("Your balance is ${request.balance}, but the transaction requires ${request.amount}.")
        }
        return ResponseEntity.ok("Transaction successful!")
    }
}

data class TransferRequest(
    val balance: Double,
    val amount: Double,
)