package com.example.handler

import com.example.services.UserService

interface User {
    fun getUser(): String
}

class UserImpl @Inject constructor(private val userService: UserService): User{

    override fun getUser():String {
      return  userService.getUser()
    }

}