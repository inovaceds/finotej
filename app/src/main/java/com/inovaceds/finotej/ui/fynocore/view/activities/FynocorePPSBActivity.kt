package com.inovaceds.finotej.ui.fynocore.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb.FynocorePPSBMenuFragment
import kotlinx.android.synthetic.main.activity_fynocore_ppsb.*
import org.jetbrains.anko.startActivity

class FynocorePPSBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fynocore_ppsb)


        changeOptionFragment(FynocorePPSBMenuFragment(), "FynocorePPSBMenuFragment")

        activity_fynocore_pp_container.setOnClickListener {
            startActivity<FynocorePPActivity>()
            finish()
        }

        activity_fynocore_fynotej_container.setOnClickListener {
            finish()
        }
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

    fun changeToOtherOption(currentFragment: Fragment, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .remove(currentFragment)
            .replace(R.id.activity_fynocore_fragment_container, fragment)
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
