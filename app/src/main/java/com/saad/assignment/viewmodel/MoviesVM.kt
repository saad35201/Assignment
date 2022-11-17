package com.saad.assignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.model.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesVM@Inject constructor(
    private val moviesRepo: MoviesRepository
): ViewModel() {


    fun getMovies()= viewModelScope.launch(Dispatchers.IO) {
        moviesRepo.getMovies()
    }

}