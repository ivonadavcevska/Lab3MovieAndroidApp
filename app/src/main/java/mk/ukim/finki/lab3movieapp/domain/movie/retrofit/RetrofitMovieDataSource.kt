package mk.ukim.finki.lab3movieapp.domain.movie.retrofit


import mk.ukim.finki.lab3movieapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieSecondFragmentDetails
import mk.ukim.finki.lab3movieapp.domain.movie.retrofit.MovieDbApi
import retrofit2.Response


class RetrofitMovieDataSource(private val movieDbApi: MovieDbApi): RemoteMovieDataSource {

    override suspend fun search(search: String): List<MovieDetails> {
        val movieResponse = movieDbApi.search(search)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody!=null){
            return responseBody.searchResults
        }
        throw Exception(movieResponse.message())
    }

    override suspend fun getMovieById(id: String): MovieSecondFragmentDetails {
        return movieDbApi.getMovieDetails(id)
    }


}
