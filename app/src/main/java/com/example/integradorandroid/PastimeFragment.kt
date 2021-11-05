package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.integradorandroid.databinding.FragmentPastimeBinding
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PastimeFragment : Fragment(R.layout.fragment_pastime) {
    lateinit var binding: FragmentPastimeBinding
    val args by navArgs<PastimeFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPastimeBinding.bind(view)
        findPastime(args.participants, args.category)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnTryAnother.setOnClickListener {
            binding.progressLoading.visibility = ProgressBar.VISIBLE
            findPastime(args.participants, args.category)
        }

    }
    private fun findPastime(participants :Int, category : String) {

        CoroutineScope(Dispatchers.IO).launch {

            var llamada: Response<PasTime>

            if (category == "Random"){
                llamada = getPastimeRetrofit()
                    .create(APIService::class.java)
                    .getRandomPastime(participants)
            }else{
                llamada = getPastimeRetrofit()
                    .create(APIService::class.java)
                    .getPastime(participants, category.lowercase())
            }

            //capturar los resultados
            val respuesta: PasTime? = llamada.body()

            //actualizar la vista con esos resultados
            activity?.runOnUiThread() {

                if (llamada.isSuccessful) {
                    binding.progressLoading.visibility = ProgressBar.INVISIBLE

                    binding.tvCategory.text = args.category
                    binding.tvParticipants.text = args.participants.toString()
                    binding.tvPasTime.text = respuesta?.activity ?: "No se encontró"
                    binding.tvPrice.text = formatPrice(respuesta?.price)

                    if (args.category == "Random"){
                        binding.tvCategoryLabel.text = respuesta?.type ?: ""
                    }else{
                        binding.ivCategory.visibility = ImageView.INVISIBLE
                    }

                }
            }

        }

    }

    private fun formatPrice(price: Float?): String{
        return price?.let {
            when(price){
                0F -> "free"
                in 0.1F..0.3F -> "Low"
                in 0.4F..0.6F -> "Medium"
                in 0.7F..1F -> "high"
                else -> ""
            }
        } ?: ""
    }

    private fun getPastimeRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}