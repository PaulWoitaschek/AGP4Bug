package com.paulwoitaschek.agptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val retrofit = Retrofit.Builder()
      .baseUrl("https://www.google.de/")
      .validateEagerly(true)
      .build()
    retrofit.create(MyInterface::class.java)
  }

  interface MyInterface {

    @GET("meop")
    fun test(date: LocalDate): Call<Void?>
  }
}
