package mk.ukim.finki.lab3movieapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import mk.ukim.finki.lab3movieapp.domain.movie.repository.MovieRepository
import retrofit2.Response

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val moviesLiveData = MutableLiveData<List<MovieDetails>>()

    private val movieDetailsLiveData = MutableLiveData<MovieSecondFragmentDetails>()

    fun getMovieLiveData(): LiveData<List<MovieDetails>> = moviesLiveData

    fun getMovieDetails(): LiveData<MovieSecondFragmentDetails> = movieDetailsLiveData

    fun search(search: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.searchMovies(search)
            moviesLiveData.postValue(movies)
        }
    }

    fun listAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.listMovies()
            moviesLiveData.postValue(movies)
        }
    }

    fun getMovieById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.getMovieById(id)
            movieDetailsLiveData.postValue(movie)
        }
    }

}