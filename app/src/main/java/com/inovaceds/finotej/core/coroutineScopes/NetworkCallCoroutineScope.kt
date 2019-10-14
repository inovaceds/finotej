package com.inovaceds.finotej.core.coroutineScopes

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class NetworkCallCoroutineScope : CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job


    fun init() {
        job = Job()
    }

    fun destroy() {
        job.cancel()
    }

}