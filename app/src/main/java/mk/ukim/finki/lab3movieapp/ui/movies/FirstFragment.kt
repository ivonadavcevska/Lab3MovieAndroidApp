package mk.ukim.finki.lab3movieapp.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import mk.ukim.finki.lab3movieapp.domain.movie.adapters.MovieAdapter
import mk.ukim.finki.lab3movieapp.R
import mk.ukim.finki.lab3movieapp.databinding.FragmentFirstBinding
import mk.ukim.finki.lab3movieapp.domain.movie.Communicator
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails


class FirstFragment : Fragment(R.layout.fragment_first), Communicator {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFirstBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]


        moviesViewModel.getMovieLiveData().observe(viewLifecycleOwner) {
            var adapter: MovieAdapter = MovieAdapter(it as ArrayList<MovieDetails>, this@FirstFragment)
            binding.list.adapter = adapter
        }



        binding.button.setOnClickListener {
            val query = binding.editQuery.text.toString()
            if (query.isEmpty()) {
                Snackbar.make(view, R.string.please_enter_query, Snackbar.LENGTH_LONG).show()
            } else {
                moviesViewModel.search(query)
            }
        }

    }

    override fun passData(position: Int, imdbId: String) {
        val bundle = Bundle()
        bundle.putInt("position", position)
        bundle.putString("imdbId", imdbId)

        val transaction = this.parentFragmentManager.beginTransaction()
        val fragment2 = SecondFragment()
        fragment2.arguments = bundle

        transaction.replace(R.id.fragment_container_view_tag, fragment2)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
