package cl.tallerandroid.manualdependencyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.tallerandroid.manualdependencyinjection.DogsResponse
import cl.tallerandroid.manualdependencyinjection.MainRepository
import retrofit2.Call

class MainViewModel(private val mainRepository: MainRepository) {

    fun getAllRaces(): Call<DogsResponse> {
        return mainRepository.getAllRaces()
    }
}