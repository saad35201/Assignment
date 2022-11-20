package com.saad.assignment.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.saad.assignment.R
import com.saad.assignment.databinding.FragmentMovieDetailBinding
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.utils.Helper.loadImage
import com.saad.assignment.viewmodel.VmMovies

class FragmentMovieDetail : Fragment() {

    //static
    private val TAG = "MovieDetail"

    //binding
    private lateinit var mBinding: FragmentMovieDetailBinding

    //view model
    private lateinit var mVmMovies: VmMovies

    //argument
    private val mArgs: FragmentMovieDetailArgs? by navArgs()

    private var movieObj: ResultsItem? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mVmMovies = ViewModelProvider(requireActivity())[VmMovies::class.java]

        mArgs?.let {
            movieObj = it.movieObj
            setData()
        }

        if (movieObj!!.isLiked) {
            mBinding.imgFav.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_heart_red
                )
            )
        } else {
            mBinding.imgFav.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_heart_white
                )
            )
        }

        //img fav click listener
        mBinding.imgFav.setOnClickListener {
            if (movieObj!!.isLiked) {
                mVmMovies.deleteMovie(movieObj!!)
                mBinding.imgFav.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_heart_white
                    )
                )
            } else {
                movieObj!!.isLiked=true
                mVmMovies.addMovie(movieObj!!)
                mBinding.imgFav.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_heart_red
                    )
                )
            }
        }

    }

    private fun setData() {
        loadImage(requireContext(), movieObj?.backdropPath!!, mBinding.imgMovieBanner)
        loadImage(requireContext(), movieObj!!.posterPath!!, mBinding.imgMoviePoster)
        mBinding.tvName.text = movieObj!!.title
        mBinding.tvReleaseDate.text = movieObj!!.releaseDate
        mBinding.tvOverviewValue.text = movieObj!!.overview
    }


}