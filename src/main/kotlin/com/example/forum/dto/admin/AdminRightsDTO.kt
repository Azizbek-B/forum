package com.example.forum.dto.admin

import com.example.forum.models.user.Users

data class DeleteUserDTO(
    var username: Int? = null
)

class DeleteResponseUserDTO(
    var username: String? = null,
    var status: String? = null
){
    fun toDTO(entity: Users, response: String){
        username = entity.username
        status = response
    }
}