package com.inovaceds.finotej.ui.fynocore.view.fragments.pp


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat

import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.fragment_fynocore_ppterminations.*


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
    }


}
