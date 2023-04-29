package com.gramzin.composable2.data.api.model


import com.google.gson.annotations.SerializedName
import ru.rigellab.hb.domain.model.CityData

data class Item(
    @SerializedName("id")
    val id: Int,
    @SerializedName("important")
    val important: Int,
    @SerializedName("title")
    val title: String
)

fun Item.toCityData(): CityData{
    return CityData(id, title)
}