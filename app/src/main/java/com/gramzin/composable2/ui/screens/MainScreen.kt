package com.gramzin.composable2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gramzin.composable2.domain.model.City
import com.gramzin.composable2.ui.viewModel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(onClick: (City) -> Unit, viewModel: MainViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        CityList(modifier = Modifier.fillMaxSize(),
            cityList = viewModel.state.value.cities, onClick = onClick)
    }
}

@Composable
fun CityList(modifier: Modifier, cityList: Flow<PagingData<City>>, onClick: (City) -> Unit){
    val cityListItems: LazyPagingItems<City> = cityList.collectAsLazyPagingItems()

    LazyColumn(modifier = modifier) {
        items(cityListItems) {city ->
            city?.let {
                CityCard(city = it, onClick = onClick)
            }
        }
    }
    cityListItems.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                //You can add modifier to manage load state when first time response page is loading
            }
            loadState.append is LoadState.Loading -> {
                //You can add modifier to manage load state when next response page is loading
            }
            loadState.append is LoadState.Error -> {
                //You can use modifier to show error message
            }
        }
    }
}

@Composable
fun CityCard(city: City, onClick: (City) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(60.dp)
            .clickable { onClick(city) }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = city.name,
                modifier = Modifier
                    .padding(horizontal = 40.dp, vertical = 4.dp)
                    .fillMaxHeight(),
                fontSize = 20.sp,
            )
        }
    }
}