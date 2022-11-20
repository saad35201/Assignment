package com.saad.assignment.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saad.assignment.databinding.FragmentFavoriteMoviesBinding
import com.saad.assignment.ui.allMovies.AdapterMovies
import com.saad.assignment.ui.allMovies.FragmentAllMoviesDirections
import com.saad.assignment.viewmodel.VmMovies

class FragmentFavoriteMovies : Fragment() {

    //static
    private val TAG = "FavoriteMovies"

    //binding
    private lateinit var mBinding: FragmentFavoriteMoviesBinding

    //view model
    private lateinit var mVmMovies: VmMovies

    //movies adapter
    private lateinit var mMoviesAdapter: AdapterMovies



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentFavoriteMoviesBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mVmMovies = ViewModelProvider(requireActivity())[VmMovies::class.java]

        mVmMovies.getAllLocalMovies().observe(requireActivity()){ it ->
            mMoviesAdapter = AdapterMovies(it)
            mBinding.rvFavMovies.adapter = mMoviesAdapter
            mMoviesAdapter.onItemClick = {
                val action = FragmentFavoriteMoviesDirections.actionFavoriteMoviesToMovieDetail(it)
                findNavController().navigate(action)
            }
        }

    }

}