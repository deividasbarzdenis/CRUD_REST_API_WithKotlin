package lt.debarz.demo.controller

import lt.debarz.demo.model.Employee
import lt.debarz.demo.service.EmployeeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/employees")
@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAll(): List<Employee> = employeeService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): Employee = employeeService.getById(id)

    @PostMapping
    fun create(@RequestBody employee: Employee): Employee = employeeService.create(employee)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody employee: Employee): Employee =
        employeeService.update(id, employee)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = employeeService.delete(id)
}
