package com.saad.assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.model.repository.RepoMovies
import com.saad.assignment.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VmMovies @Inject constructor(private val moviesRepo: RepoMovies) : ViewModel() {

    var page = 1

    val movieList = MutableLiveData<List<ResultsItem>?>()

    fun loadAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesRepo.getMovies(Constants.API_KEY)

            if (response.isSuccessful) {
                movieList.postValue(response.body()?.results as List<ResultsItem>?)
                //saving loaded in room db
                moviesRepo.insertAllMovies(response.body()?.results as List<ResultsItem>)
            }

        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesRepo.searchMovie(query, page)
            if (response.isSuccessful) {
                movieList.postValue(response.body()?.results as List<ResultsItem>?)
            }
        }
    }

    /*-----------------Local------------------*/

    fun getAllLocalMovies(): LiveData<List<ResultsItem>> {
        return moviesRepo.getAllLocalMovies()
    }

    fun addMovie(movie: ResultsItem) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesRepo.addMovie(movie)
        }
    }

    fun deleteMovie(movie: ResultsItem) {
        viewModelScope.launch(Dispatchers.IO) {
            moviesRepo.deleteMovie(movie)
        }
    }

}