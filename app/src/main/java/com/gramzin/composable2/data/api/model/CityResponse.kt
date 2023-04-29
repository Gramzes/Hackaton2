package com.gramzin.composable2.data.api.model


import com.google.gson.annotations.SerializedName
import ru.rigellab.hb.domain.model.CityData

data class CityResponse(
    @SerializedName("response")
    val response: Response
)

fun CityResponse.toData(): List<CityData>{
    return response.items.map { it.toCityData() }
}