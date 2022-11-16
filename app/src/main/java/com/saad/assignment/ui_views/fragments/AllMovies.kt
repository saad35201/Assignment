package com.saad.assignment.ui_views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saad.assignment.R
import com.saad.assignment.databinding.FragmentAllMoviesBinding


class AllMovies : Fragment() {

    //static
    private val TAG = "AllMovies"

    //binding
    private lateinit var mBinding: FragmentAllMoviesBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentAllMoviesBinding.inflate(inflater,container,false)
        return mBinding.root
    }


}