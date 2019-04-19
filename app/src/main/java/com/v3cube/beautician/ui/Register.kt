package com.v3cube.beautician.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.v3cube.beautician.R
import com.v3cube.beautician.networking.ApiClient
import com.v3cube.beautician.networking.ApiService
import com.v3cube.beautician.pojo.RegisterData
import com.v3cube.beautician.pojo.RegisterPojo
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Register : AppCompatActivity() {

    private var tag = "goRegister"

    private var cCode = arrayOf("+91", "+355", "+213", "+376", "+244", "+1684", "+1264", "+1268", "+54", "+374", "+297", "+61", "+43", "+994", "+1242", "+973", "+880")
    private lateinit var conCodeData: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        title = "REGISTER"

        val cCodeAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cCode)
        cCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conCode.adapter = cCodeAdapter

        conCode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                conCodeData = cCode[position]
            }
        }

        rSubmit.setOnClickListener {
            if (allValidation()) {
                val fn = rFirstName.text.toString().trim()
                val ps = rPassword.text.toString().trim()
                val eml = rEmail.text.toString().trim()
                val phn = conCodeData + " " + rMobile.text.toString().trim()
                val ln = rLastName.text.toString().trim()
                val ref = rReferral.text.toString().trim()
                getRegisterRetroData(fn,ps,eml,phn,ln,ref)
            }
        }

    }

    private fun allValidation(): Boolean {
        when {
            rFirstName.length() == 0 -> {
                rFirstName.error = "this field is required"
                Toast.makeText(this@Register, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }

            rLastName.length() == 0 -> {
                rFirstName.error = null
                rLastName.error = "this field is required."
                Toast.makeText(this@Register, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }
            rEmail.length() == 0 -> {
                rLastName.error = null
                rEmail.error = "this field is required."
                Toast.makeText(this@Register, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }
            rPassword.length() == 0 || rPassword.length() < 5 -> {
                rEmail.error = null
                rPassword.error = "atleast 5 digits required."
                Toast.makeText(this@Register, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }
            rMobile.length() == 0 || rMobile.length() < 10 -> {
                rPassword.error = null
                rMobile.error = "enter a valid number."
                Toast.makeText(this@Register, "All fields are required", Toast.LENGTH_SHORT).show()
                return false
            }

            !rTermCondition.isChecked -> {
                rTermCondition.error = "Agree to Term & Condition"
                rMobile.error = null
                Toast.makeText(this@Register, "Accept TERM & CONDITION", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                rTermCondition.error = null
                return true
            }
        }
    }

    private fun getRegisterRetroData(fn: String, ps: String, mail: String, mob: String, ln: String, refId: String) {

        val apiService = ApiClient().retroData.create(ApiService::class.java)
        val call = apiService.sendRegisterData(fn, ps, mail, mob, ln, refId)

            call.enqueue(object : Callback<RegisterData> {
            override fun onFailure(call: Call<RegisterData>?, t: Throwable?) {
                Log.d(tag, t.toString())
            }

            override fun onResponse(call: Call<RegisterData>?, response: Response<RegisterData>?) {
                if (response!!.isSuccessful) {
                    Log.d(tag, "response code - " + response.code())
                    Log.d(tag, "response body - " + response.body().message)
                    startActivity(Intent(this@Register, Login::class.java))
                    Toast.makeText(this@Register, "Success", Toast.LENGTH_SHORT).show()
                    finish()

                }
            }
        })
    }
}
