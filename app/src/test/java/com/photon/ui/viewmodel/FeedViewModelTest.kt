package com.photon.ui.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.photon.base.BaseTest
import com.photon.domain.FeedUseCase
import com.photon.repository.FeedRepository
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class FeedViewModelTest : BaseTest() {

    private val feedUseCase = mock(FeedUseCase::class.java)
    private val feedViewModel = FeedViewModel(feedUseCase)

    @Rule @JvmField
    val instanceExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testNotNull(){
        assertNotNull(feedViewModel)
        assertThat(feedViewModel.feedMutableLiveData, notNullValue())
        verify(feedUseCase, never()).getFeed(ArgumentMatchers.anyString())
    }



    override fun isMockServerEnable() = true




}