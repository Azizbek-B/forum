package com.example.forum.services.user

import com.example.forum.dto.admin.ResponseSignInDTO
import com.example.forum.dto.admin.SignInDTO
import com.example.forum.dto.admin.SignUpDTO
import com.example.forum.models.user.Users

interface IUserService{
    fun createUser(dto: SignUpDTO): Users
    fun checkLoginDetails(dto: SignInDTO): ResponseSignInDTO
    fun getActiveByUsername(username: String): Users?

    fun getAllByRole(role: String): List<Users>
}