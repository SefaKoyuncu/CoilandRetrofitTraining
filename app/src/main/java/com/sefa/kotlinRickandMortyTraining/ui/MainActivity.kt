package com.sefa.kotlinRickandMortyTraining.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sefa.kotlinRickandMortyTraining.data.ApiCallService
import com.sefa.kotlinRickandMortyTraining.ui.adapter.RVAdapter
import com.sefa.kotlinRickandMortyTraining.data.ResponseJSON
import com.sefa.kotlinRickandMortyTraining.databinding.ActivityMainBinding
import com.sefa.kotlinRickandMortyTraining.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var arraylistCharacters: ArrayList<Results>
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getCharacters()
        setRV()
    }

    fun getCharacters()
    {
        ApiCallService.call().enqueue(object: Callback<ResponseJSON>{

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {

                Log.e("body",response.body().toString())

                if (response.body()!=null)
                {
                    binding.rv.setHasFixedSize(true)
                    binding.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    adapter= RVAdapter(this@MainActivity,response.body()!!.results)
                    binding.rv.adapter=adapter

                }




            }

            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                Log.e("hata",t.toString())
            }

        })



    }

    fun setRV()
    {

    }
}