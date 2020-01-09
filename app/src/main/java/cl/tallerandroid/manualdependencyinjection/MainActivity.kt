package cl.tallerandroid.manualdependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainService::class.java)

        val remoteDataSource = MainRemoteDataSource(retrofit)
        val mainRepository = MainRepository(remoteDataSource)

        val dogs = MainViewModel(mainRepository).getAllRaces()

        val textView: TextView = findViewById(R.id.razasTextView) as TextView

        dogs.enqueue(object : retrofit2.Callback<DogsResponse> {
            override fun onFailure(call: Call<DogsResponse>?, t: Throwable?) {
                Log.d("DOG ERROR",t?.message)
            }

            override fun onResponse(call: Call<DogsResponse>?, response: Response<DogsResponse>?) {
                val out = response?.body().toString()
                Log.d("DOG OK", out)
                textView.text = out

            }
        })



    }

}
