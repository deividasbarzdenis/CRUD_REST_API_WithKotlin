package lt.debarz.demo.model

import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(unique = true, nullable = false)
    val username: String,
    @Column(nullable = false)
    val firstName: String,
    @Column(nullable = false)
    val middleName: String,
    @Column(nullable = false)
    val lastName: String,
    @Column(nullable = false)
    val email: String,
    @Column(nullable = false)
    val dayOfBirth: String
)
