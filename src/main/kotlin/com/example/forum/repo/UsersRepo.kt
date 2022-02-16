package com.example.forum.repo

import com.example.forum.models.user.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UsersRepo: JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {
    fun findByUsername(username: String): Users?
}