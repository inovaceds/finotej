package com.inovaceds.finotej.ui.fynocore.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inovaceds.finotej.ui.fynocore.view.fragments.applications.PPPosFragment
import com.inovaceds.finotej.ui.fynocore.view.fragments.applications.PPStandsFragment

class PPAplicationsPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PPStandsFragment()
            1 -> PPPosFragment()
            else -> Fragment()
        }

    }

    override fun getCount(): Int = 2
}