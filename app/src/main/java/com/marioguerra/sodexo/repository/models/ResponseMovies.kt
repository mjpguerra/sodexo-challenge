package com.marioguerra.sodexo.repository.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Mario Guerra on 20/08/2018
 */
class ResponseMovies(

    @SerializedName("title")
    @Expose
    var  nomeFilme : String?,

    @SerializedName("year")
    @Expose
    var ano : String?

){
    override fun toString(): String {
        return "ResponseMovies(nomeFilme=$nomeFilme, ano=$ano)"
    }
}

