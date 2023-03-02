package mk.ukim.finki.lab3movieapp.domain.movie.repository

import mk.ukim.finki.lab3movieapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import mk.ukim.finki.lab3movieapp.domain.movie.room.LocalMovieDataSource
import mk.ukim.finki.lab3movieapp.domain.movie.utils.NetworkConnectivity
import retrofit2.Response

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource,
                      private val localMovieDataSource: LocalMovieDataSource,
                      private val networkConnectivity: NetworkConnectivity
) {
    suspend fun searchMovies(search: String): List<MovieDetails> {

        if (networkConnectivity.isNetworkAvailable) {
            return remoteMovieDataSource.search(search).apply {
                localMovieDataSource.saveAll(this)
            }
        }
          return localMovieDataSource.searchMovies(search)
    }

    suspend fun listMovies(): List<MovieDetails> {
        return localMovieDataSource.getAll()
    }

    suspend fun getMovieById(id: String): MovieSecondFragmentDetails {
        return remoteMovieDataSource.getMovieById(id)
    }

}