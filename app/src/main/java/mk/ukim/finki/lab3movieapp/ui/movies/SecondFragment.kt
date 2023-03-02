package mk.ukim.finki.lab3movieapp.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import mk.ukim.finki.lab3movieapp.R
import mk.ukim.finki.lab3movieapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSecondBinding.bind(view)

        var imdbId: String = arguments?.getString("imdbId").toString()

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        moviesViewModel.getMovieById(imdbId).toString()

        moviesViewModel.getMovieDetails().observe(viewLifecycleOwner) {
            binding.movieTitle.text = it?.title
            Glide.with(binding.movieImage).load(it?.poster)
                .centerCrop().placeholder(R.drawable.ic_movie).into(binding.movieImage)
            binding.moviePlot.text = it?.plot
            binding.movieYear.text = it?.year
        }


    }
}