package com.saad.assignment.ui_views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saad.assignment.R
import com.saad.assignment.databinding.FragmentFavoriteMoviesBinding

class FavoriteMovies : Fragment() {

    //static
    private val TAG = "FavoriteMovies"

    //binding
    private lateinit var mBinding: FragmentFavoriteMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentFavoriteMoviesBinding.inflate(inflater,container,false)
        return mBinding.root
    }

}