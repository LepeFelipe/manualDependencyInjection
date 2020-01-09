package cl.tallerandroid.manualdependencyinjection

import retrofit2.Call

class MainRemoteDataSource(private val mainService: MainService) {
    fun getAllRaces(): Call<DogsResponse> {
        return mainService.getRazas()
    }
}