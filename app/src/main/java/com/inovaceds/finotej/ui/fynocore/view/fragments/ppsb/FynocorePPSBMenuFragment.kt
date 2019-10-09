package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPSBActivity
import kotlinx.android.synthetic.main.fragment_ppsbmenu.*

/**
 * A simple [Fragment] subclass.
 */
class FynocorePPSBMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ppsbmenu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_pp_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeOptionFragment(
                FynocorePPSBDetailFragment(),
                "FynocorePPSBDetail"
            )
        }

        fragment_fynocore_panel_terminations_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeOptionFragment(
                FynocorePPSBTerminationsFragment(),
                "FynocorePPSBPanelTerminations"
            )
        }

        fragment_fynocore_aplications_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeOptionFragment(
                FynocorePPSBApplicationsFragment(),
                "FynocorePPSBApplications"
            )
        }

    }


}
