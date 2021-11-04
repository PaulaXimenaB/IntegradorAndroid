package com.example.integradorandroid

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {

  /*  @GET
    suspend fun getPastime(@Url url:String):Response<PasTime>*/

     @GET ("activity?")
    suspend fun getPastime(@Query("participants") participants: Int, @Query("type")category : String):Call<PasTime>
   /* @GET("activity?")
    fun getActivityDetaill(
        @Query("type",encoded = true) type: String,
        @Query("participants",encoded = true) participants: String

    ): Call<DetailModel>*/
    @GET
    suspend fun getRandomPastime(participants : Int) : Response<PasTime>
}