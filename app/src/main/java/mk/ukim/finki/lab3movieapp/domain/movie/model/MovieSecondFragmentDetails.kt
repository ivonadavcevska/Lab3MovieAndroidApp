package mk.ukim.finki.lab3movieapp.domain.movie.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class MovieSecondFragmentDetails(
    @SerializedName("imdbID") val imdbId: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Plot") val plot: String) {
}