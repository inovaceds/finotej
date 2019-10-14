package com.inovaceds.finotej.ui.fynocore.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb.applications.PPSBApplicationsItemFragment

class PPSBApplicationsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {

        return when(position){
            0->PPSBApplicationsItemFragment.getInstance("Creación de Escenografias", R.drawable.ppsb_escenografia)
            1->PPSBApplicationsItemFragment.getInstance("Decoración de Interiores", R.drawable.ppsb_decoraciones)
            2->PPSBApplicationsItemFragment.getInstance("Divisiones y Pisos", R.drawable.ppsb_divisiones)
            3->PPSBApplicationsItemFragment.getInstance("Remodelaciones", R.drawable.ppsb_remodelaciones)
            else -> Fragment()
        }
    }

    override fun getCount(): Int = 4
}