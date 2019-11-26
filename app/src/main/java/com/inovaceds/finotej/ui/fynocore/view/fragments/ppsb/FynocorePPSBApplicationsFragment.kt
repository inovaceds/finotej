package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPSBActivity
import com.inovaceds.finotej.ui.fynocore.view.adapters.PPSBApplicationsPagerAdapter
import com.inovaceds.finotej.ui.pdfPreview.PDFPreviewActivity
import kotlinx.android.synthetic.main.fragment_fynocore_ppsbapplications.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class FynocorePPSBApplicationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppsbapplications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_applications_view_pager.adapter =
            PPSBApplicationsPagerAdapter(childFragmentManager)

        fragment_fynocore_applications_view_pager_dots.setupWithViewPager(
            fragment_fynocore_applications_view_pager
        )


        fragment_fynocore_send_information.setOnClickListener {
            context?.startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.PP_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.FYNOCORE_PRODUCT
            )
        }
        fragment_fynocore_applications_pp_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeToOtherOption(
                this,
                FynocorePPSBDetailFragment()
            )
        }

        fragment_fynocore_applications_panel_terminations_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeToOtherOption(
                this,
                FynocorePPSBTerminationsFragment()
            )
        }


    }

}
