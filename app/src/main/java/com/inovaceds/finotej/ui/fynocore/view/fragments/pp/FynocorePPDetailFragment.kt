package com.inovaceds.finotej.ui.fynocore.view.fragments.pp


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.fragment_fynocore_ppdetail.*


class FynocorePPDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppdetail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoUri = Uri.parse("android.resource://${context?.packageName}/${R.raw.panel_pp_video}")
        fragment_fynocore_detail_video_view.setVideoFromUri(context,videoUri)

        fragment_fynocore_detail_video_view.setLooping(true)
        fragment_fynocore_detail_video_view.start()

        /*val videoUri = Uri.parse("android.resource://${context?.packageName}/${R.raw.panel_pp_video}")
        fragment_fynocore_detail_video_view.setVideoURI(videoUri)
        fragment_fynocore_detail_video_view.setOnPreparedListener {
            it.isLooping = true
        }

        fragment_fynocore_detail_video_view.start()*/

    }


}
