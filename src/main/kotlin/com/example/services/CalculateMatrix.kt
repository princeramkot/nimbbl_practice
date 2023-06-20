package com.example.services


import com.example.model.Matrix
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.statement.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.*

import java.util.*
import kotlin.random.Random

class CalculateMatrixClass {

    suspend fun getMatrixMultiplication() = coroutineScope {
        val client = HttpClient(CIO)
        var rpm = 0
        val startTime = System.currentTimeMillis()
        val totalMinutes = 1
        val endTime = startTime + ((totalMinutes * 15) * 1000)

        val listOfResponse = mutableListOf<Deferred<String>>()
        val responseTime  =  mutableListOf<Long>()
//        while (System.currentTimeMillis() < endTime) {
        repeat(10000) {
            val random = Random.nextInt(1, 5)
            val requestBody = """{"rows": $random,
            "columns":$random
            }""".trimMargin()
            //listOfResponse.add(async { fetchData(client, requestBody) })
            val start = System.currentTimeMillis()

            async { fetchData(client, requestBody) }.await()

            responseTime.add(System.currentTimeMillis() - start)
            rpm++

        }
        println("bingo ,, im here boii")

           // val res = listOfResponse.awaitAll()
            responseTime.sort()
        println(responseTime)
        val index = (responseTime.size * 0.99).toInt()
        val p99 = responseTime[index]

        val p95Index = (responseTime.size * 0.95).toInt()

        println("=> $index $p95Index")
        val p95 = responseTime[p95Index]
            println("All  completed successfully. in ${System.currentTimeMillis() - startTime}ms")


        println("P99 : $p99")
        println("P95 : $p95")
        println("RPM : $rpm")
        println("RPS : ${rpm / (totalMinutes * 60)}")
    }

    suspend fun fetchData(client: HttpClient, requestBody: String): String {
        return client.request("http://0.0.0.0:8082/calculate") {
            method = HttpMethod.Post
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.bodyAsText()
    }

}