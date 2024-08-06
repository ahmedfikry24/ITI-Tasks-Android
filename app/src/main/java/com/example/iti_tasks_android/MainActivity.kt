package com.example.iti_tasks_android

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.iti_tasks_android.ui.GalleryFragment
import com.example.iti_tasks_android.ui.HomeFragment
import com.example.iti_tasks_android.ui.SlideShowFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var toolBar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpToolBar()
        setUpNavDrawer()
    }

    private fun setUpNavDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout)
        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.close, R.string.open)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        actionBarDrawerToggle.drawerArrowDrawable.color = getColor(R.color.white)
        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
    }

    private fun setUpToolBar() {
        toolBar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)
        toolBar.overflowIcon?.let { icon ->
            DrawableCompat.setTint(icon, getColor(android.R.color.white))
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.start_intent -> navigateToAnotherActivity()
            R.id.settings -> fragmentNavigation(SettingsFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                fragmentNavigation(HomeFragment())
            }

            R.id.gallery -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                fragmentNavigation(GalleryFragment())
            }

            R.id.slideshow -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                fragmentNavigation(SlideShowFragment())
            }

        }
        return true
    }

    private fun navigateToAnotherActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun fragmentNavigation(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
            .commit()
    }

}