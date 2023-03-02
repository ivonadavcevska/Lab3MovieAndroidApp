package mk.ukim.finki.lab3movieapp.domain.movie.room

import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import retrofit2.Response

class RoomMovieDataSource(private val movieDao: MovieDao): LocalMovieDataSource {

    override suspend fun insert(movie: MovieDetails) {
        movieDao.insert(movie)
    }

    override suspend fun saveAll(movies: List<MovieDetails>) {
        for(movie in movies) {
            movieDao.insert(movie)
        }
    }

    override suspend fun delete(id: Int) {
        movieDao.delete(id)
    }

    override suspend fun getAll(): List<MovieDetails> {
        return movieDao.getAll()
    }

    override suspend fun searchMovies(search: String): List<MovieDetails> {
        return movieDao.searchMovies(search)
    }





}