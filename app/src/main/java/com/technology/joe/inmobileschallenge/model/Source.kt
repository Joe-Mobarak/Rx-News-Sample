package com.technology.joe.inmobileschallenge.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Source(
    @field:Json(name = "id") val id: Any,
    @field:Json(name = "name") val name: Any
) : Serializable
