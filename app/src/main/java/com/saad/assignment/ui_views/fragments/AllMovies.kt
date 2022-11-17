package com.saad.assignment.ui_views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saad.assignment.R
import com.saad.assignment.databinding.FragmentAllMoviesBinding
import com.saad.assignment.ui_views.adapters.MoviesAdapter
import com.saad.assignment.viewmodel.MoviesVM


class AllMovies : Fragment() {

    //static
    private val TAG = "AllMovies"
    //binding
    private lateinit var mBinding: FragmentAllMoviesBinding
    //viewModel
    private val mMoviesVM: MoviesVM by viewModels()
    //movies adapter
    private lateinit var mMoviesAdapter: MoviesAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentAllMoviesBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}