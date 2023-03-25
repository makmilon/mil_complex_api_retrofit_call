package com.milon.complexapiusingretrofit.apiInterface

import com.makd.retrofitwithdiffapi.model.QuoteList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    fun getQuote(@Query ("page") page: Int) : Call<QuoteList>
}