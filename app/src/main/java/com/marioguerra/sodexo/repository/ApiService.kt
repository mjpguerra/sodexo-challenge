package com.marioguerra.sodexo.repository

import com.marioguerra.sodexo.repository.models.ResponseMovies
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Mario Guerra on 20/08/2018
 */
interface ApiService {

    @GET("movies/popular")
    fun getFilmesPopulares() : Call<ResponseMovies>

    @GET("movies/trending")
    fun getFilmesTendencia()

}