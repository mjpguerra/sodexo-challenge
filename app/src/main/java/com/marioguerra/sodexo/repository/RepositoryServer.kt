package com.marioguerra.sodexo.repository

import com.marioguerra.sodexo.repository.models.ResponseMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryServer {

    fun getFilmesPopulares(){
        val retrofit = ConfigRetrofit.initRetrofit()
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<ResponseMovies> = apiService.getFilmesPopulares()
        call.enqueue(object : Callback<ResponseMovies> {
            override fun onResponse(call: Call<ResponseMovies>, response: Response<ResponseMovies>) {

            }
            override fun onFailure(call: Call<ResponseMovies>, t: Throwable) {

                t.printStackTrace()
            }
        })
    }

}