package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import coil.ImageLoader
import coil.api.load
import coil.decode.GifDecoder

import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.fragment_fynocore_ppdetail.*

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

        fragment_fynocore_detail_video_view?.load(R.drawable.gif_ppsb, imageLoader)


    }

}
