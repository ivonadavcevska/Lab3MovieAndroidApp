package mk.ukim.finki.lab3movieapp.domain.movie.retrofit

import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieResponse
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {

    @GET(".")
    suspend fun search(@Query("s") s: String): Response<MovieResponse>

    @GET(".")
    suspend fun getMovieDetails(@Query("i") i: String): MovieSecondFragmentDetails
}