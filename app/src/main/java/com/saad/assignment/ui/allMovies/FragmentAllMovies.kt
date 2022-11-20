package com.saad.assignment.ui.allMovies

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saad.assignment.R
import com.saad.assignment.databinding.FragmentAllMoviesBinding
import com.saad.assignment.utils.NetworkUtil
import com.saad.assignment.viewmodel.VmMovies
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAllMovies : Fragment() {

    //static
    private val TAG = "AllMovies"

    //binding
    private lateinit var mBinding: FragmentAllMoviesBinding

    //viewModel
    //private val mVMMovies: VmMovies by viewModels()
    private lateinit var mVmMovies: VmMovies

    //movies adapter
    private lateinit var mMoviesAdapter: AdapterMovies

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentAllMoviesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mVmMovies = ViewModelProvider(requireActivity())[VmMovies::class.java]

        //btn fab fav click listener
        mBinding.fabFavorites.setOnClickListener {
            findNavController().navigate(R.id.action_allMovies_to_favoriteMovies)
        }

        //movies observer
        mVmMovies.movieList.observe(requireActivity(), Observer { it ->
            mMoviesAdapter = it?.let { it1 -> AdapterMovies(it1) }!!
            mBinding.rvMovies.adapter = mMoviesAdapter
            mMoviesAdapter.onItemClick = {
                val action = FragmentAllMoviesDirections.actionAllMoviesToMovieDetail(it)
                findNavController().navigate(action)
            }
        })

        if (NetworkUtil.checkConnectivity(requireContext())) {
            mVmMovies.loadAllMovies()
        } else {
            mVmMovies.getAllLocalMovies().observe(requireActivity()) { it1 ->
                mMoviesAdapter = AdapterMovies(it1)
                mBinding.rvMovies.adapter = mMoviesAdapter
                mMoviesAdapter.onItemClick = {
                    val action = FragmentAllMoviesDirections.actionAllMoviesToMovieDetail(it)
                    findNavController().navigate(action)
                }
            }
        }



        //sv view query listener
        mBinding.svMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (TextUtils.isEmpty(p0)) {
                    mVmMovies.loadAllMovies()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    mVmMovies.searchMovies(p0)
                }
                return false
            }
        })

    }

}