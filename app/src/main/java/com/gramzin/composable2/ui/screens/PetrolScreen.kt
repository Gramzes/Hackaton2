package com.gramzin.composable2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gramzin.composable2.domain.model.Fuel
import com.gramzin.composable2.domain.model.Period
import java.util.Calendar
import java.util.Date

@Composable
fun PetrolScreen(onClick: (Fuel, Period) -> Unit) {
    val calendar: Calendar = Calendar.getInstance()
    calendar.add(Calendar.MONTH, -6)
    val dateStartDefault: Date = calendar.time
    val dateEndDefault = Date(System.currentTimeMillis())

    val fuels = remember {
        mutableStateListOf<Fuel>(Fuel(0,"Москва"), Fuel(1, "Казань"))
    }
    val period = remember {
        mutableStateOf<Period>(value = Period(dateStartDefault, dateEndDefault))
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(fuels) { index: Int, fuel: Fuel ->
                PetrolCard(fuel, onClick = {
                    onClick(it, period.value)
                })
            }
        }
    }
}

@Composable
fun PetrolCard(fuel: Fuel, onClick: (Fuel) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(60.dp)
            .clickable { onClick(fuel) }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = fuel.name,
                modifier = Modifier
                    .padding(horizontal = 40.dp, vertical = 4.dp)
                    .fillMaxHeight(),
                fontSize = 20.sp,
            )
        }
    }
}