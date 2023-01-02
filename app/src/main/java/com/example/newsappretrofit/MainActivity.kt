package com.example.newsappretrofit

import MODELS_CLASS.News
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//1f2e109c082d4ee4b2ad94f523c1f220
class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    private fun getNews()
    {
        val news=NewsService.newsInstance.getNewsHeadlines("in",1)
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("output_value","successfully reciever")

                val news=response.body()
                if(news!=null)
                {
                    adapter=MyAdapter(this@MainActivity,news.articles)
                    recyclerView.adapter=adapter
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("output_value","error")
            }

        })
    }
}