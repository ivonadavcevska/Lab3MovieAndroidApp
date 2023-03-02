package mk.ukim.finki.lab3movieapp.domain.movie

import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import retrofit2.Response

interface RemoteMovieDataSource {
    suspend fun search(search: String): List<MovieDetails>

    suspend fun getMovieById(id: String): MovieSecondFragmentDetails
}