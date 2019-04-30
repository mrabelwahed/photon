package com.photon.repository

import com.photon.common.FEED_PARAM
import com.photon.data.Response
import com.photon.model.Feed
import com.photon.network.FeedService
import io.reactivex.Observable
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit

class FeedRepositoryTest{


    @Rule
    @JvmField
    var rule = MockitoJUnit.rule()!!

    @Mock
    lateinit var service:FeedService

    @Mock
    lateinit var observable: Observable<List<Response>>

    lateinit var repository: FeedRepository


    @Before
    fun setup(){
        repository = FeedRepository(service)
    }

    @Test
    fun `when getFeed is called should call retrofit service and retrurn response`(){
        Mockito.`when`(repository.getFeed(ArgumentMatchers.anyString())).thenReturn(observable)
         val result = repository.getFeed(ArgumentMatchers.anyString())
        assertThat(result ,`is` (observable))
        verify(service).getFeed(ArgumentMatchers.anyString())
        verifyNoMoreInteractions(service)
    }


}