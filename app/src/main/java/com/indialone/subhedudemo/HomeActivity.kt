package com.indialone.subhedudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.indialone.subhedudemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityHomeBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mUserViewModel = ViewModelProvider(this, ViewModelFactory()).get(UserViewModel::class.java)

        mBinding.switchHome.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                buttonView.isChecked = true
                mBinding.root.setBackgroundColor(resources.getColor(R.color.green))
            } else {
                buttonView.isChecked = false
                mBinding.root.setBackgroundColor(resources.getColor(R.color.red))
            }
        }

        mUserViewModel.getUserDetails().observe(this) {
            mBinding.userdetails.setText("$it")
        }

//        mBinding.switchHome.setOnClickListener {
//            if (mBinding.switchHome.isChecked) {
//                mBinding.switchHome.isChecked = false
//                mBinding.root.setBackgroundColor(resources.getColor(R.color.red))
//            } else {
//                mBinding.switchHome.isChecked = true
//                mBinding.root.setBackgroundColor(resources.getColor(R.color.green))
//            }
//        }


    }
}