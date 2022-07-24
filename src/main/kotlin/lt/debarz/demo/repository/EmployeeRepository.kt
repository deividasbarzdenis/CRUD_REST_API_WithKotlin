package lt.debarz.demo.repository

import lt.debarz.demo.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
}
