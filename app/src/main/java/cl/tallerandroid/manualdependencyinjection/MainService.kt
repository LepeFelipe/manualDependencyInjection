package cl.tallerandroid.manualdependencyinjection

import retrofit2.Call
import retrofit2.http.GET

interface MainService {

    @GET("breeds/list/all")
    fun getRazas(): Call<DogsResponse>

}