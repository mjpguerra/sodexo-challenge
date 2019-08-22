package com.marioguerra.sodexo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.marioguerra.sodexo.repository.ApiService
import com.marioguerra.sodexo.repository.ConfigRetrofit
import com.marioguerra.sodexo.repository.RepositoryServer
import com.marioguerra.sodexo.repository.models.ResponseMovies
import com.marioguerra.sodexo.utils.DebugSodexo
import kotlinx.android.synthetic.main.activity_movies.*
import org.movies.android.testesodexo.ui.movies.MoviesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var  moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        setupmoviesRecycler()

        getFilmesPopulares()

    }

    private fun setupmoviesRecycler() {
        moviesAdapter = MoviesAdapter()
        recycler_movies.layoutManager = LinearLayoutManager(this)
        recycler_movies.adapter = moviesAdapter
    }


    private fun setupScreenForLoadingState() {
        progress.visibility = View.VISIBLE
        recycler_movies.visibility = View.GONE
        view_empty.visibility = View.GONE
        view_error.visibility = View.GONE
    }

    private fun setupScreenForSuccess(data: List<ResponseMovies>?) {
        view_error.visibility = View.GONE
        progress.visibility = View.GONE
        if (data!= null && data.isNotEmpty()) {
            updateListView(data)
            recycler_movies.visibility = View.VISIBLE
        } else {
            view_empty.visibility = View.VISIBLE
        }
    }

    private fun updateListView(Movies: List<ResponseMovies>) {
        moviesAdapter.movies = Movies
        moviesAdapter.notifyDataSetChanged()
    }

    private fun setupScreenForError(message: String?) {
        progress.visibility = View.GONE
        recycler_movies.visibility = View.GONE
        view_empty.visibility = View.GONE
        view_error.visibility = View.VISIBLE
    }


    val TAG = "SERVER"


    fun getFilmesPopulares()  {
        setupScreenForLoadingState()

        val retrofit = ConfigRetrofit.initRetrofit()
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<List<ResponseMovies>> = apiService.getFilmesPopulares()
        call.enqueue(object : Callback<List<ResponseMovies>> {
            override fun onResponse(call: Call<List<ResponseMovies>>, response: Response<List<ResponseMovies>>) {
                setupScreenForSuccess(response.body())
                DebugSodexo.Log.i(TAG,response.toString() )
            }

            override fun onFailure(call: Call<List<ResponseMovies>>, t: Throwable) {
                DebugSodexo.Log.e(TAG, "Error: ${t.message}")
                setupScreenForError(t.message)
                t.printStackTrace()
            }
        })
    }

}
