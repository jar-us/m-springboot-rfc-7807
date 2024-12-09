package jar.us.springbootrfc7807

class InsufficientFundsException(
    val detail: String
) : RuntimeException(detail)