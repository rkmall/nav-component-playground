package com.rm.android_navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.rm.android_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        // Set toolbar as actionbar
        val toolbar = binding.includedToolbar.toolbar
        setSupportActionBar(toolbar)

        /**
         * Retrieving NavController from Activity:
         * If we're using <FragmentContainerView> element, we should get the NavHostFragment first
         * and then retrieve NavController from the NavHostFragment.
         * It is the recommended solution.
         */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        /**
         * Retrieving NavController from Activity:
         * Activity.findNavController only works with <fragment> element
         * It is not a recommended if we're using <FragmentContainerView>
         */
        //navController = findNavController(R.id.nav_host_fragment)

        /**
         * Top level destinations do not show Up button.
         *  - specify top-level destinations
         *  - fallback support for navigateUp()
         */
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.splashFragment, R.id.homeFragment),
            fallbackOnNavigateUpListener = { onSupportNavigateUp() }
        )

        //setupActionBarWithNavController(navController, appBarConfiguration)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp() || super.onSupportNavigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return item.onNavDestinationSelected(findNavController(R.id.navHostFragment))
                || super.onOptionsItemSelected(item)
    }
}
