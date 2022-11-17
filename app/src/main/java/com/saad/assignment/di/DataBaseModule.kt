package com.saad.assignment.di

import com.saad.assignment.model.retrofit.MovieAPIService
import com.saad.assignment.model.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    /*------------------------------------Cloud Database------------------------------------*/

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit{
        return RetrofitClient.getInstance()
    }

    @Singleton
    @Provides
    fun provideMoviesAPI(): MovieAPIService{
        return provideRetrofitClient().create(MovieAPIService::class.java)
    }

    /*------------------------------------Local Database------------------------------------*/

//    @Singleton
//    @Provides
//    fun provideRoomDB(@ApplicationContext appContext: Context): RoomDB {
//        return RoomDB.getInstance(appContext)
//    }
//
//    @Singleton
//    @Provides
//    fun provideEmployDao(roomDB: RoomDB) : EmployDao{
//        return roomDB.employDao()
//    }

}