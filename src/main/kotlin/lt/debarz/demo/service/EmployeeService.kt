package lt.debarz.demo.service

import lt.debarz.demo.exception.EmployeeNotFoundException
import lt.debarz.demo.model.Employee
import lt.debarz.demo.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAll(): List<Employee> = employeeRepository.findAll()

    fun getById(id: Long): Employee = employeeRepository.findById(id)
        .orElseThrow { EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found") }

    fun create(employee: Employee): Employee = employeeRepository.save(employee)

    fun update(id: Long, employee: Employee): Employee {
        if (!employeeRepository.existsById(id)) throw EmployeeNotFoundException(
            HttpStatus.NOT_FOUND,
            "No matching employee was found"
        )
        return employeeRepository.save(employee)
    }

    fun delete(id: Long){
        if (!employeeRepository.existsById(id)) throw EmployeeNotFoundException(
            HttpStatus.NOT_FOUND,
            "No matching employee was found")
        employeeRepository.deleteById(id)
    }
}
