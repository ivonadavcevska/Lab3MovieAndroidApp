package mk.ukim.finki.lab3movieapp.domain.movie

interface Communicator {
    fun passData(position: Int, imdbId: String)
}