package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.api.load
import coil.decode.GifDecoder
import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPSBActivity
import com.inovaceds.finotej.ui.pdfPreview.PDFPreviewActivity
import kotlinx.android.synthetic.main.fragment_fynocore_ppsbdetail.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class FynocorePPSBDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppsbdetail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_detail_description_text.text = HtmlCompat.fromHtml(
            getString(R.string.fynocore_ppsb_description),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        val imageLoader = ImageLoader(context!!) {
            componentRegistry {
                add(GifDecoder())
            }
            crossfade(1000)
        }

        fragment_fynocore_detail_video_view?.load(R.drawable.ppsb, imageLoader)

        fragment_fynocore_send_information.setOnClickListener {
            context?.startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.PP_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.FYNOCORE_PRODUCT
            )
        }

        fragment_fynocore_aplications_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeToOtherOption(
                this,
                FynocorePPSBApplicationsFragment()
            )
        }

        fragment_fynocore_detail_panel_terminations_option.setOnClickListener {
            (activity as FynocorePPSBActivity).changeToOtherOption(
                this,
                FynocorePPSBTerminationsFragment()
            )
        }
    }

}
