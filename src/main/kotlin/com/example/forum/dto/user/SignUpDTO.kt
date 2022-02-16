package com.example.forum.dto.admin

import com.example.forum.models.user.Users

data class SignUpDTO(
    var id: Long = 0L,
    var username: String,
    var password: String,
    var email: String?,
    var role: String?
)

class SignUpResponseDTO {
    var id: Long? = null
    var username: String? = null
    var email: String? = null
    var role: String? = null

    fun toDTO(entity: Users): SignUpResponseDTO {
        this.id = entity.id
        this.username = entity.username
        this.email = entity.email
        this.role = entity.role

        return this
    }
}

data class SignInDTO(
    var username: String,
    var password: String
)

class ResponseSignInDTO{
    var username: String? = null
    var sign_in_status: String? = null

    fun toDTO(entity: Users, status: String?): ResponseSignInDTO {
        this.username = entity.username
        this.sign_in_status = status
        return this

    }
}