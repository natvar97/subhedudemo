package com.indialone.subhedudemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.indialone.subhedudemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private var email: String = ""
    private var password: String = ""
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mUserViewModel = ViewModelProvider(this, ViewModelFactory()).get(UserViewModel::class.java)

        mBinding.btnSingIn.setOnClickListener {
            if (validateDetails()) {
                val user = User(email, password)
                mUserViewModel.postUserDetails(user)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

    }

    private fun validateDetails(): Boolean {
        email = mBinding.etEmail.text.toString().trim { it <= ' ' }
        password = mBinding.etPassword.text.toString().trim { it <= ' ' }

        return when {
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this, "Provide valid email", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this, "Provde valid password", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }

}