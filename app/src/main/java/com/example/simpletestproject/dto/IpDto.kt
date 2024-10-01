package com.example.simpletestproject.dto

import com.google.gson.annotations.SerializedName

data class IpDto(
    @SerializedName("myip") val ip: String,
)