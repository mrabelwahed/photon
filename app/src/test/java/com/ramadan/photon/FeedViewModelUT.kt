package com.ramadan.photon

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.ramadan.photon.base.BaseTest
import com.ramadan.photon.common.FEED_PARAM
import com.ramadan.photon.ui.BaseActivity
import com.ramadan.photon.ui.viewmodel.FeedViewModel
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.HttpURLConnection


class FeedViewModelUT : BaseTest() {

    @Rule
    @JvmField
    val instanceTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FeedViewModel
    private lateinit var activity: FragmentActivity

    override fun isMockServerEnable(): Boolean = true


    @Before
    override fun setup() {
        super.setup()
        this.viewModel = ViewModelProviders.of(this.activity, viewModelFactory)[FeedViewModel::class.java]
    }



    // TESTS
    @Test
    fun getFeed_whenSuccess() {
        // Prepare data
        this.mockHttpresponse("getFeed_whenSuccess.json", HttpURLConnection.HTTP_OK)
        // Pre-test
        assertEquals(
            null,
            this.viewModel.feedMutableLiveData.value,
            "feed should be null because stream not started yet"
        )
        // Execute View Model
        this.viewModel.getFeed(FEED_PARAM)
        // Checks
        assertNotNull(this.viewModel.feedMutableLiveData.value)
        //assertEquals(false, this.viewModel.isLoading.value, "Should be reset to 'false' because stream ended")
        // assertEquals(null, this.viewModel.errorMessage.value, "No error must be founded")
    }

    @Test
    fun getFeed_whenError() {
        // Prepare data
        this.mockHttpresponse("getFeed_whenSuccess.json", HttpURLConnection.HTTP_BAD_GATEWAY)
        // Pre-test
        assertEquals(
            null,
            this.viewModel.feedMutableLiveData.value,
            "Feed should be null because stream not started yet"
        )
        // Execute View Model
        this.viewModel.getFeed(FEED_PARAM)
        // Checks
        assertEquals(null, this.viewModel.feedMutableLiveData.value, "User must be null because of http error")
        //assertEquals(false, this.viewModel.isLoading.value, "Should be reset to 'false' because stream ended")
        //assertNotEquals(null, this.viewModel.errorMessage.value, "Error value must not be empty")
    }
}