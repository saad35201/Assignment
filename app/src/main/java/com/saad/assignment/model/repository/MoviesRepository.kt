package com.saad.assignment.model.repository

import com.saad.assignment.model.models.MoviesResponse
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.model.retrofit.MovieAPIService
import com.saad.assignment.utils.Constants
import javax.inject.Inject

class MoviesRepository@Inject constructor(
    var apiService: MovieAPIService
) {

    suspend fun getMovies(): List<ResultsItem?>? {
        return apiService.getMovies(Constants.API_KEY).results
    }

}