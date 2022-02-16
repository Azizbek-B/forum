package com.example.forum.models.user

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(unique = true)
    @Size(min = 6, max = 20)
    var username: String = ""

    @Column
    @Size(max = 100)
    var password: String = ""
        @JsonIgnore(false)
        get
        set(value) {
            field = BCryptPasswordEncoder().encode(value)
        }

    @Column
    @Size(max = 50)
    var email: String? = ""

    @Column
    @Size(max = 15)
    var role: String? = ""
}