package com.inovaceds.finotej.ui.fynocore.view.fragments.pp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.dialog.view.SendInformationDialogFragment
import com.inovaceds.finotej.ui.fynocore.view.adapters.PPAplicationsPagerAdapter
import kotlinx.android.synthetic.main.fragment_fynocore_ppapplications.*

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

        fragment_fynocore_send_information.setOnClickListener {
            val dialog = SendInformationDialogFragment.getInstance(
                DataConfiguration.FYNOCORE_PRODUCT,
                DataConfiguration.PP_DOCUMENT)

            dialog.isCancelable = false
            dialog.show(childFragmentManager,"SendInformationDialog")
        }
    }


}
