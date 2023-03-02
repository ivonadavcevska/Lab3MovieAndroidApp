package mk.ukim.finki.lab3movieapp.domain.movie.model

import com.google.gson.annotations.SerializedName


data class MovieResponse (@SerializedName("Search") val searchResults: List<MovieDetails>) {
}