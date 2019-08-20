package com.marioguerra.sodexo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marioguerra.sodexo.repository.RepositoryServer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RepositoryServer().getFilmesPopulares()
    }
}
