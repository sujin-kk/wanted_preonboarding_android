package com.wanted.preob.newsapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wanted.preob.newsapp.data.api.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://newsapi.org/"
    private const val API_KEY = "e21097ee5d1d4cc0ba09d9e64d739021"

    @Provides
    @Singleton
    fun providesLoggerInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun providesHeaderInterceptor() = Interceptor { chain ->
        with(chain) {
            val request = request().newBuilder()
                .addHeader("X-Api-Key", API_KEY)
                .build()
            proceed(request)
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun providesConvertorMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        convertorMoshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(convertorMoshi).asLenient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesNewsApi(retrofit: Retrofit): NewsApi
        = retrofit.create(NewsApi::class.java)
}