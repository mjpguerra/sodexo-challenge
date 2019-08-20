package com.marioguerra.sodexo.repository

import com.google.gson.Gson
import com.marioguerra.sodexo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ConfigRetrofit {

    var URLBase : String  = "https://api.trakt.tv/"

    fun initRetrofit(gson: Gson? = null, timeout: Long? = 90): Retrofit {


        var okClient = OkHttpClient.Builder()

        okClient.writeTimeout(timeout!!, TimeUnit.SECONDS)
        okClient.connectTimeout(timeout, TimeUnit.SECONDS)
        okClient.readTimeout(timeout, TimeUnit.SECONDS)

        okClient.interceptors().add(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header("Content-Type", "application/json")
            requestBuilder.header("trakt-api-version", "2")
            requestBuilder.header("trakt-api-key", "1234")
            requestBuilder.method(original.method(), original.body())
            chain.proceed(requestBuilder.build())
        })


        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okClient.interceptors().add(interceptor)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(URLBase)
            .client(okClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        if (gson != null)
            retrofit.newBuilder().addConverterFactory(GsonConverterFactory.create(gson))

        return retrofit

    }


}