package com.saad.assignment.model.network

import com.saad.assignment.model.models.MoviesResponse
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("movie/popular?")
    suspend fun getMovies(
        @Query("api_key") api_key: String?
    ): Response<MoviesResponse>

    @GET("search/movie?")
    suspend fun searchMovie(
        @Query("api_key") api_key: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ) : Response<MoviesResponse>

}