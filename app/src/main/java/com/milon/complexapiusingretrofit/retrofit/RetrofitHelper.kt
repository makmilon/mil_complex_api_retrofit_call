package com.makd.retrofitwithdiffapi.retrofit



import com.milon.complexapiusingretrofit.apiInterface.QuotesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val BASE_URL= "https://api.quotable.io/"

    private val retrofit by lazy {

        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(QuotesApi::class.java)
    }
}