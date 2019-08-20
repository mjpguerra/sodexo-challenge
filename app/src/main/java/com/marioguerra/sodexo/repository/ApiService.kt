package com.marioguerra.sodexo.repository

import retrofit2.http.GET

/**
 * @author Mario Guerra on 20/08/2018
 */
interface ApiService {

    @GET("movies/popular")
    fun getFilmesPopulares()

    @GET("movies/trending")
    fun getFilmesTendencia()

}