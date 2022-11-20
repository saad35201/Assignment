package com.saad.assignment.model.repository

import androidx.lifecycle.LiveData
import com.saad.assignment.model.models.MoviesResponse
import com.saad.assignment.model.models.ResultsItem
import com.saad.assignment.model.network.WebServices
import com.saad.assignment.model.roomdb.RoomDB
import com.saad.assignment.utils.Constants
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepoMovies @Inject constructor(
    var services: WebServices,
    var room: RoomDB
) {

    /*------------Live------------*/

    suspend fun getMovies(apiKey:String?): Response<MoviesResponse> {
        return services.getMovies(apiKey)
    }

    suspend fun searchMovie(query: String, page: Int): Response<MoviesResponse> {
        return services.searchMovie(Constants.API_KEY, query, page)
    }

    /*------------Local------------*/

    fun getAllLocalMovies(): LiveData<List<ResultsItem>>{
        return room.movieDao().getMovies()
    }

    suspend fun insertAllMovies(list: List<ResultsItem>){
        return room.movieDao().insertAllMovies(list)
    }

    suspend fun addMovie(movie: ResultsItem){
        return room.movieDao().addMovie(movie)
    }

    suspend fun deleteMovie(movie: ResultsItem){
        return room.movieDao().deleteMovie(movie)
    }

}