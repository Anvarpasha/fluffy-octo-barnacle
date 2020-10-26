package com.anvarpasha.avtogarage.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.anvarpasha.avtogarage.ui.dashboard.MainActivity
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (prefs.getToken().isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }else {

            val navController = this.findNavController(R.id.nav_host_container)

            setSupportActionBar(toolbar)

            NavigationUI.setupActionBarWithNavController(this, navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_container)
        return navController.navigateUp()
    }

    override fun onPrepareSupportNavigateUpTaskStack(builder: TaskStackBuilder) {
        super.onPrepareSupportNavigateUpTaskStack(builder)
    }

}