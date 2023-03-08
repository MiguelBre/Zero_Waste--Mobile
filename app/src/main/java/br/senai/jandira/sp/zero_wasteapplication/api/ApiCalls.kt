package br.senai.jandira.sp.zero_wasteapplication.api

import br.senai.jandira.sp.zero_wasteapplication.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCalls {

    @POST("gerador")
    fun saveReciclador(@Body reciclador: User): Call<User>

}