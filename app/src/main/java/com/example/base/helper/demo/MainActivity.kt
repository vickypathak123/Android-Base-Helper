package com.example.base.helper.demo

import com.example.app.base.helper.BaseActivity
import com.example.app.base.helper.BaseBindingActivity
import com.example.base.helper.demo.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun getActivityContext(): BaseActivity {
        return this@MainActivity
    }

    override fun setBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}