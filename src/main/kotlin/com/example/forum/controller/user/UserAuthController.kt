package com.example.forum.controller.user

import com.example.forum.dto.admin.ResponseSignInDTO
import com.example.forum.dto.admin.SignInDTO
import com.example.forum.dto.admin.SignUpDTO
import com.example.forum.dto.admin.SignUpResponseDTO
import com.example.forum.models.user.Users
import com.example.forum.services.user.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/")
class UserAuthController @Autowired constructor(
    val service: IUserService,
    ){
    @PostMapping("sign_up")
    fun signup(@RequestBody body: SignUpDTO): SignUpResponseDTO{
        val user = this.service.createUser(body)

        return SignUpResponseDTO().toDTO(user)
    }

    @PutMapping("login")
    fun login(@RequestBody body: SignInDTO): ResponseSignInDTO {
        return service.checkLoginDetails(body)

    }

    @GetMapping("role")
    fun getAllByRole(@PathParam("byrole") byrole: String):List<Users> {
        return service.getAllByRole(byrole)
    }
}

