package com.example.nit3213finalassignment.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)

@JsonClass(generateAdapter = true)
data class DashboardResponse(
    @Json(name = "entities") val entities: List<Entity>,
    @Json(name = "entityTotal") val entityTotal: Int
)

@JsonClass(generateAdapter = true)
data class Entity(
    @Json(name = "name") val name: String,
    @Json(name = "architect") val architect: String,
    @Json(name = "location") val location: String,
    @Json(name = "yearCompleted") val yearCompleted: Int,
    @Json(name = "style") val style: String,
    @Json(name = "height") val height: Int,
    @Json(name = "description") val description: String
)