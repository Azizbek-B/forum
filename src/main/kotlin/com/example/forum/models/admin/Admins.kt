package com.example.forum.models.admin

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity(name="administrators")
class Admins {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Column(unique = true)
    var username: String = ""

    @Column
    @Size(max=100)
    var password: String = ""

    @Column(unique = true)
    @Size(max=50)
    var email: String = ""

    @Column
    var rank: Int = 0

}