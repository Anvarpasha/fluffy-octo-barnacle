package com.anvarpasha.avtogarage.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import com.anvarpasha.avtogarage.ui.orders.OrderHistoryFragment
import com.anvarpasha.avtogarage.ui.profile.ProfileActivity
import com.anvarpasha.avtogarage.ui.search.SearchActivity
import com.google.android.material.tabs.TabLayout
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)


        setSupportActionBar(toolbar)
        supportActionBar?.setIcon(R.drawable.avtogarage)

        viewPager.adapter = setUpViewPager()
        tabLayout.setupWithViewPager(viewPager)


        Log.e("Data-Main", prefs.getToken())

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()

    }



    private fun setUpViewPager() : MyPagerAdapter {

        val myPagerAdapter = MyPagerAdapter(supportFragmentManager)


        val fragment1 = OrderHistoryFragment()
        val fragment2 = OrderHistoryFragment()

        myPagerAdapter.addFragment(fragment1,"Cavab gözləyənlər")
        myPagerAdapter.addFragment(fragment2,"Hamısı")

        return myPagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.action_profile -> {

                startActivity(Intent(this,ProfileActivity::class.java))
            }

            R.id.action_search -> {
                startActivity(Intent(this,SearchActivity::class.java))
            }

        }

        return true
    }

}