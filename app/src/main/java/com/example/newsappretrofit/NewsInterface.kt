package com.example.newsappretrofit

import MODELS_CLASS.News
import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1f2e109c082d4ee4b2ad94f523c1f220
//https://newsapi.org/v2/top-headlines?country=in&apiKey=1f2e109c082d4ee4b2ad94f523c1f220

const val BASE_URL="https://newsapi.org/v2/"
const val API_KEY="1f2e109c082d4ee4b2ad94f523c1f220"
interface NewsInterface {


    @GET("top-headlines?apiKey=$API_KEY")
    fun getNewsHeadlines(@Query("country") country:String,@Query("page") page:Int) : retrofit2.Call<News>

    //https://newsapi.org/v2/top-headlines?apiKey=1f2e109c082d4ee4b2ad94f523c1f220&country=in&page=1

}


object NewsService{

    val newsInstance:NewsInterface

    init {
        val retrofit:Retrofit=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance=retrofit.create(NewsInterface::class.java)
    }


}