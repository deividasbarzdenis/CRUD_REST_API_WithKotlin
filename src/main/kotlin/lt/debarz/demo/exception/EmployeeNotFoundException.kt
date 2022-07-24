package lt.debarz.demo.exception

import org.springframework.http.HttpStatus

class EmployeeNotFoundException(val status: HttpStatus, val reason: String) : Exception()
