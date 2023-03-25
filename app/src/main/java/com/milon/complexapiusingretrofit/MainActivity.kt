package com.milon.complexapiusingretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.makd.retrofitwithdiffapi.model.QuoteList


import com.makd.retrofitwithdiffapi.retrofit.RetrofitHelper
import com.milon.complexapiusingretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // complex array within array calling and show in text
        subcategory()

        //complex array direct call api and show in text
      //  category()

    }

    private fun category() {
        val re=   RetrofitHelper.apiInterface.getQuote(1)
        re.enqueue(object : Callback<QuoteList?> {
            override fun onResponse(call: Call<QuoteList?>, response: Response<QuoteList?>) {

                //to call specific category
                if (re != null){
                    val repo= response.body()?.totalCount
                    if (repo != null) {

                        binding.memeAuthor.text = repo.toString()

                    }

                }
                //
                //to call all category
//                if (re != null){
//                    binding.memeAuthor.text= response.body().toString()
//
//                }
            }

            override fun onFailure(call: Call<QuoteList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun subcategory() {

        val re=   RetrofitHelper.apiInterface.getQuote(1)
        re.enqueue(object : Callback<QuoteList?> {
            override fun onResponse(call: Call<QuoteList?>, response: Response<QuoteList?>) {
                if (re != null){
                    val repo = response.body()?.results

                    if (repo != null) {
                        for (array in repo) {
                            binding.memeAuthor.text = array.author
                            binding.memeTitle.text = array.content

                        }

                    }
                }
            }

            override fun onFailure(call: Call<QuoteList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}