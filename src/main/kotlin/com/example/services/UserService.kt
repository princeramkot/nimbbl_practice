package com.example.services

import org.slf4j.LoggerFactory

interface UserService {
    fun getUser()
}

class UserServiceImpl(): UserService{
    override fun getUser(){
      val log = LoggerFactory.getLogger(UserService::class.java)
        log.info("user fetched !!")
    }
}