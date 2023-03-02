package mk.ukim.finki.lab3movieapp.domain.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieDetails(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("imdbID") val imdbId: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("Year") val year: String) {
}