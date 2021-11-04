package com.example.integradorandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.navigation.fragment.navArgs
import com.example.integradorandroid.databinding.FragmentPastimeBinding
import kotlinx.coroutines.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PastimeFragment : Fragment(R.layout.fragment_pastime) {
    lateinit var binding: FragmentPastimeBinding
    val args by navArgs<PastimeFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPastimeBinding.bind(view)
       // binding.tv.text = args.participants.toString()
        findPastime(args.participants, args.category)
    }
    private fun findPastime(participants :Int, category : String) {

        CoroutineScope(Dispatchers.IO).launch {
            var respuesta :PasTime? = null
            val llamada = getPastimeRetrofit()
                .create(APIService::class.java)
                .getPastime(participants, category)


            //capturar los resultados

                respuesta= llamada.body()



            //actualizar la vista con esos resultados
          //  GlobalScope.launch(Dispatchers.Main) {
          //  activity?.runOnUiThread(){

               /* if (llamada.isSuccessful) {
                    binding.tv.text = respuesta?.activity ?: "No se encontró"
                }*/
           //3 }

        }


    }

    private fun getPastimeRetrofit(): Retrofit {


        return Retrofit.Builder().baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}