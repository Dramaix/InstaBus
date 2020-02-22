package com.example.instabus.stations

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.instabus.AboutActivity
import com.example.instabus.HomeActivity
import com.example.instabus.R
import com.example.instabus.models.Station
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_station_list_nav.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.toolbar.*

@SuppressLint("Registered")
class StationsListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, StationsAdapter.CocktailItemListener  {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, StationsListActivity::class.java)
            context.startActivity(intent)
        }

    }

    private val drawerLayout by lazy {
        findViewById<DrawerLayout>(R.id.drawer)
    }


    private lateinit var swipeLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView


    private val TAG = "StationsListActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_list_nav)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        nav_view.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav_drawer, R.string.close_nav_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        Log.i(TAG, "onCreate")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about ->
                AboutActivity.start(this)
            R.id.action_cocktails -> start(this)
            R.id.action_home -> HomeActivity.start(this)
        }
        return true
    }


    override fun onCocktailItemClick(cocktail: Station) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}