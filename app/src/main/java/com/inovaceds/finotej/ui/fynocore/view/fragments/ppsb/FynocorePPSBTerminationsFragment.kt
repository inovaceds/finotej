package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat

import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.dialog.view.SendInformationDialogFragment
import com.inovaceds.finotej.ui.fynocore.view.adapters.PPSBTerminationsPagerAdapter
import kotlinx.android.synthetic.main.fragment_fynocore_ppsbterminations.*

/**
 * A simple [Fragment] subclass.
 */
class FynocorePPSBTerminationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppsbterminations, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_terminations_description_text.text =
            HtmlCompat.fromHtml(
                getString(R.string.fynocore_ppsb_termination),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )

        fragment_fynocore_terminations_view_pager.adapter =
            PPSBTerminationsPagerAdapter(childFragmentManager)

        fragment_fynocore_terminations_view_pager_dots.setupWithViewPager(
            fragment_fynocore_terminations_view_pager,
            true
        )


        fragment_fynocore_send_information.setOnClickListener {
            val dialog = SendInformationDialogFragment.getInstance(
                DataConfiguration.FYNOCORE_PRODUCT,
                DataConfiguration.PPSB_DOCUMENT)

            dialog.isCancelable = false
            dialog.show(childFragmentManager,"SendInformationDialog")
        }

    }

}
