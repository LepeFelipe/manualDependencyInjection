package cl.tallerandroid.manualdependencyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val mainRemoteDataSource: MainRemoteDataSource) {

    fun getAllRaces(): Call<DogsResponse> {
        return mainRemoteDataSource.getAllRaces()
    }

}