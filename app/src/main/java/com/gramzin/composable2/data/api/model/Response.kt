package com.gramzin.composable2.data.api.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<Item>
)