package com.inovaceds.finotej.ui.fynocore.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.adapters.PPAplicationsPagerAdapter
import kotlinx.android.synthetic.main.fragment_fynocore_ppapplications.*
import kotlinx.android.synthetic.main.fragment_fynocore_ppterminations.*

class FynocorePPApplicationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppapplications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_applications_view_pager.adapter = PPAplicationsPagerAdapter(childFragmentManager)

        fragment_fynocore_applications_view_pager_dots.setupWithViewPager(
            fragment_fynocore_applications_view_pager, true
        )
    }


}
