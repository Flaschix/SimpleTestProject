package com.example.simpletestproject.network

import com.example.simpletestproject.dto.IpDto
import com.example.simpletestproject.entity.IP
import retrofit2.http.GET

interface ApiService {
    @GET("/d4e2bt6jba6cmiekqmsv/")
    suspend fun getIpAddress(): IpDto
}