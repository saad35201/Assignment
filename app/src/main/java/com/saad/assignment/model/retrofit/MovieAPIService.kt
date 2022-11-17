package com.saad.assignment.model.retrofit

import com.saad.assignment.model.models.MoviesResponse
import com.saad.assignment.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {

    @GET("movie/popular?")
    suspend fun getMovies(
        @Query("api_key") api_key: String
    ) : MoviesResponse

}