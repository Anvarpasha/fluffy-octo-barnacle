package com.anvarpasha.avtogarage.ui.profile

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.persistence.GarageApp.Companion.prefs
import com.anvarpasha.avtogarage.databinding.ProfileActivityBinding
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.profile_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ProfileActivityBinding
    private val viewModel: ProfileVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.profile_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        viewModel.properties.observe(this, {
            Glide.with(this).load(it.logoImg).circleCrop().into(binding.logoImg)
            Glide.with(this).load(it.coverImg).into(binding.coverImg)
        })

        viewModel.getProfileScreenAsync()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        logout_btn.setOnClickListener {
            prefs?.logOut()
        }


        return true
    }

}