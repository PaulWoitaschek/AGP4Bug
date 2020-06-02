package com.paulwoitaschek.agptest

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val handler = Handler()

    OkHttpClient()
      .newCall(
        Request.Builder()
          .url("https://www.google.com/")
          .get()
          .build()
      )
      .enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
          handler.post {
            textView.text = e.toString()
          }
        }

        override fun onResponse(call: Call, response: Response) {
          handler.post {
            textView.text = response.body!!.string()
          }
        }
      })
  }
}
