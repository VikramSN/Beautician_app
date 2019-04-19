package com.v3cube.beautician.ui

import android.content.Context
import android.os.Bundle
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.v3cube.beautician.R
import com.v3cube.beautician.main.MainPage
import com.v3cube.beautician.networking.ApiClient
import com.v3cube.beautician.networking.ApiService
import com.v3cube.beautician.pojo.DataLogin
import com.v3cube.beautician.pojo.LoginPojo

import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private var tag="goLogin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "LOGIN"

        lLogin.setOnClickListener {
            if(allLoginValidation()) {
            getLoginRetroData(lUserPhEm.text.toString().trim(),lUserPass.text.toString().trim())
            }
        }
    }

    private fun allLoginValidation(): Boolean {
        when {
            lUserPhEm.length() == 0 -> {
                lUserPhEm.error = "this field is required"
                Toast.makeText(this@Login, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }

            lUserPass.length() == 0 -> {
                lUserPhEm.error = null
                lUserPass.error = "this field is required."
                Toast.makeText(this@Login, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                lUserPass.error = null
                return true
            }
        }
    }

    private fun getLoginRetroData(un:String,ps:String) {

        val apiService = ApiClient().retroData.create(ApiService::class.java)
        val call = apiService.sendLoginData(un,ps)
        call.enqueue(object: Callback<DataLogin> {
            override fun onFailure(call: Call<DataLogin>?, t: Throwable?) {
                Log.d(tag,t.toString())
                Toast.makeText(this@Login,"Invalid Username and Password",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DataLogin>?, response: Response<DataLogin>?) {

                if(response!!.isSuccessful) {
                    Log.d(tag,"response code - "+response.code())
                    val editor = getSharedPreferences("goCosmicUserData", Context.MODE_PRIVATE).edit()
                    editor.putString("uid", response.body().message[0].id)
                    editor.putString("uname", response.body().message[0].name)
                    editor.putString("uemail", response.body().message[0].email)
                    editor.putString("umobile", response.body().message[0].mobile)
                    editor.putString("uref", response.body().message[0].referenceId)
                    editor.apply()
                    startActivity(Intent(this@Login, MainPage::class.java))
                }else {
                    Toast.makeText(this@Login,"Invalid Username and Password",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}
