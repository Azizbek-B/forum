package com.example.forum.services.user

import com.example.forum.dto.admin.ResponseSignInDTO
import com.example.forum.dto.admin.SignInDTO
import com.example.forum.dto.admin.SignUpDTO
import com.example.forum.main
import com.example.forum.models.user.Users
import com.example.forum.repo.UsersRepo
import com.example.forum.specifications.AdminRightsSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class UserService @Autowired constructor(
    val mainRepo: UsersRepo
) : IUserService {

    override fun createUser(dto: SignUpDTO): Users {
        val entity = if (getActiveByUsername(dto.username) == null)
            Users()
        else
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST,
                "Current user '${dto.username}' already exists in database!")
        entity.username = dto.username
        entity.password = dto.password
        entity.email = dto.email
        entity.role = dto.role

        mainRepo.save(entity)
        return entity
    }

    //Checking if user and password are correct, and return the result
    override fun checkLoginDetails(dto: SignInDTO): ResponseSignInDTO {
        val entity = getActiveByUsername(dto.username)
        if (entity == null)
            throw  HttpClientErrorException(HttpStatus.BAD_REQUEST,
            "There is no user with username '${dto.username}' ")
        else {
            val isPasswordTrue = BCrypt.checkpw(dto.password, entity.password)
        }

        return ResponseSignInDTO().toDTO(entity, "Success")



    }

    override fun getActiveByUsername(username: String): Users? {
        return mainRepo.findByUsername(username)
    }

    override fun getAllByRole(role: String): List<Users>{
        val specification = AdminRightsSpecification(role)
        return mainRepo.findAll(specification)
    }

}
