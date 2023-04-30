package com.gramzin.composable2.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gramzin.composable2.data.api.apiService.CitiesApiService
import com.gramzin.composable2.data.storage.CitiesRemoteStorage
import retrofit2.HttpException
import ru.rigellab.hb.domain.model.CityData
import java.io.IOException
import javax.inject.Inject

class CityPagingSource @Inject constructor(private val citiesRemoteStorage: CitiesRemoteStorage)
    : PagingSource<Int, CityData>() {

    override fun getRefreshKey(state: PagingState<Int, CityData>): Int?
    {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CityData> {
        return try {
            val nextPage = params.key ?: 1
            val count = params.loadSize
            val offset = count * (nextPage - 1)
            val citiesList = citiesRemoteStorage.getCities(count, offset)
            LoadResult.Page(
                data = citiesList,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (citiesList.size < count) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }


    class Factory @Inject constructor(private val citiesRemoteStorage: CitiesRemoteStorage){
        fun create(): CityPagingSource{
            return CityPagingSource(citiesRemoteStorage)
        }
    }

}