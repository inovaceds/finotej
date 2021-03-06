package com.inovaceds.finotej.ui.fynocore.view.fragments.pp


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPActivity
import com.inovaceds.finotej.ui.pdfPreview.PDFPreviewActivity
import kotlinx.android.synthetic.main.fragment_fynocore_ppterminations.*
import org.jetbrains.anko.startActivity


class FynocorePPTerminationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppterminations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoUri = Uri.parse("android.resource://${context?.packageName}/${R.raw.cubo}")
        fragment_fynocore_terminations_video_view.setVideoFromUri(context,videoUri)

        fragment_fynocore_terminations_video_view.setLooping(true)
        fragment_fynocore_terminations_video_view.start()

        fragment_fynocore_terminations_description_text.text = HtmlCompat.fromHtml(
            getString(R.string.fynocore_terminations_description),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        fragment_fynocore_send_information.setOnClickListener {
            context?.startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.PP_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.FYNOCORE_PRODUCT
            )
        }

        fragment_fynocore_aplications_option.setOnClickListener {
            (activity as FynocorePPActivity).changeToOtherOption(
                this,
                FynocorePPApplicationsFragment()
            )
        }

        fragment_fynocore_terminations_pp_option.setOnClickListener {
            (activity as FynocorePPActivity).changeToOtherOption(
                this,
                FynocorePPDetailFragment()
            )
        }

    }


}
