package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.services.CalculateMatrixClass
import io.ktor.client.engine.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

suspend fun main(args: Array<String>): Unit  {
   val c = CalculateMatrixClass()
      c.getMatrixMultiplication()

}