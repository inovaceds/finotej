package com.inovaceds.finotej.ui.fynocore.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb.terminations.TerminationItemFragment

class PPSBTerminationsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> TerminationItemFragment.getInstance("Panel de Melamina", R.drawable.ppsb_melamina)
            1 -> TerminationItemFragment.getInstance("Fibra de Vidrio", R.drawable.ppsb_fibra)
            2 -> TerminationItemFragment.getInstance("Panel de Yeso", R.drawable.ppsb_yeso)
            3 -> TerminationItemFragment.getInstance("Poliforma 3D", R.drawable.ppsb_poliforma)
            4 -> TerminationItemFragment.getInstance("Panel Antiderrapante", R.drawable.ppsb_antiderrapante)
            5 -> TerminationItemFragment.getInstance("Panel FYNOSTONE", R.drawable.ppsb_fynostone)
            6 -> TerminationItemFragment.getInstance("Panel PPSB", R.drawable.ppsb_ppsb)
            else -> Fragment()
        }
    }

    override fun getCount(): Int = 7
}