package com.marioguerra.sodexo.repository

import com.marioguerra.sodexo.repository.models.ResponseMovies
import com.marioguerra.sodexo.utils.DebugSodexo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryServer {

    val TAG = "SERVER"


    fun getFilmesPopulares(){
        val retrofit = ConfigRetrofit.initRetrofit()
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<MutableList<ResponseMovies>> = apiService.getFilmesPopulares()
        call.enqueue(object : Callback<MutableList<ResponseMovies>> {
            override fun onResponse(call: Call<MutableList<ResponseMovies>>, response: Response<MutableList<ResponseMovies>>) {

                DebugSodexo.Log.i(TAG,response.toString() )
            }

            override fun onFailure(call: Call<MutableList<ResponseMovies>>, t: Throwable) {
                DebugSodexo.Log.e(TAG, "Error: ${t.message}")

                t.printStackTrace()
            }
        })
    }

}