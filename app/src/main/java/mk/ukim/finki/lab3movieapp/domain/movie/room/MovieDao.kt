package mk.ukim.finki.lab3movieapp.domain.movie.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import retrofit2.Response

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: MovieDetails)

    @Delete
    suspend fun deleteMovie(movie: MovieDetails)

    @Query("DELETE FROM moviedetails WHERE id=:id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM MovieDetails")
    suspend fun getAll(): List<MovieDetails>

    @Query("SELECT * FROM MovieDetails WHERE title LIKE :query")
    suspend fun searchMovies(query: String): List<MovieDetails>

    //@Query("SELECT * FROM MovieDetails WHERE imdbId LIKE :id")
   // suspend fun getMovie(id: String): MovieSecondFragmentDetails
}