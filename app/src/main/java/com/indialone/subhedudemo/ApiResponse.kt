package com.indialone.subhedudemo

data class ApiResponse(
	val phone: String? = null,
	val roles: List<String?>? = null,
	val name: String? = null,
	val id: Int? = null,
	val accessToken: String? = null,
	val tokenType: String? = null,
	val email: String? = null,
	val username: String? = null
)
