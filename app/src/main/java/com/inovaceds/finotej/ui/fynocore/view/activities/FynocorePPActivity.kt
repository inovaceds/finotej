package com.inovaceds.finotej.ui.fynocore.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.fragments.FynocorePPMenuFragment

class FynocorePPActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fynocore)

        changeOptionFragment(FynocorePPMenuFragment(), "FynocoreMenuFragment")
    }

    fun changeOptionFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .replace(R.id.activity_fynocore_fragment_container, fragment)
            .addToBackStack(tag)
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount != 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }

    }
}
