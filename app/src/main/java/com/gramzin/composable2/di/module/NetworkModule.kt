package com.gramzin.composable2.di.module

import com.gramzin.composable2.data.api.ApiUtils
import com.gramzin.composable2.data.api.apiService.CitiesApiService
import com.gramzin.composable2.data.paging.CityPagingSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.rigellab.hb.data.repository.CityRepositoryImpl
import ru.rigellab.hb.domain.repository.CityRepository
import javax.inject.Singleton

@Module(includes = [NetworkBindsModule::class])
object NetworkModule {
    @Provides
    fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiUtils.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCityApi(retrofit: Retrofit): CitiesApiService {
        return retrofit.create(CitiesApiService::class.java)
    }
}