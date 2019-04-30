package com.photon.domain

import com.photon.base.BaseTest
import com.photon.base.RxSchedulerRule
import com.photon.common.FEED_PARAM
import com.photon.data.Response
import com.photon.di.DaggerBaseComponent
import com.photon.di.NetworkModule
import com.photon.model.Feed
import com.photon.network.FeedService
import com.photon.repository.FeedRepository
import com.squareup.okhttp.mockwebserver.MockResponse
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import okhttp3.OkHttpClient
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import java.net.HttpURLConnection
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Inject


class FeedUseCaseTest : BaseTest() {

    private val testObserver = TestObserver<List<Response>>()
    lateinit var useCase: FeedUseCase
    lateinit var  service:FeedService

    @Mock
    lateinit var repository:FeedRepository

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()!!

    @Rule
    @JvmField
    var testSchedulerRule = RxSchedulerRule()


    override fun setup() {
        super.setup()
        useCase = FeedUseCase(repository)
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockServer.url("/").toString())
            .build()
        service =  retrofit.create(FeedService::class.java)

    }


    @Test
    fun testNotNull() {
        Assert.assertNotNull(useCase)
    }

    @Test
    fun getFeed_whenSuccess() {
        mockHttpresponse("getFeed_whenSuccess.json", HttpURLConnection.HTTP_OK)
        service.getFeed(FEED_PARAM).subscribe(testObserver)
        testObserver.assertNoErrors()
        testObserver.assertComplete()
    }

    @Test
    fun getError_when_there_is_internal_server_error() {
        this.mockHttpResponse(MockResponse().setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR))
        service.getFeed(FEED_PARAM).subscribe(testObserver)
        testObserver.assertNoValues()
        assertEquals(1,testObserver.errorCount())
    }

    override fun isMockServerEnable() = true



}