package mk.ukim.finki.lab3movieapp.domain.movie.room

import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import retrofit2.Response

interface LocalMovieDataSource {

    suspend fun insert(movie:MovieDetails)

    suspend fun saveAll(movies: List<MovieDetails>)

    suspend fun delete(id: Int)

    suspend fun getAll(): List<MovieDetails>

    suspend fun searchMovies(search: String): List<MovieDetails>

    //suspend fun getMovieById(id: String): MovieSecondFragmentDetails
}