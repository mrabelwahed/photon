package com.photon.base

import com.photon.common.BASE_URL
import com.photon.di.*
import com.photon.ui.viewmodel.ViewModelFactory
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File
import javax.inject.Inject

abstract class BaseTest {

    lateinit var mockServer: MockWebServer
    lateinit var testAppComponent:TestAppComponent
    fun startMockServer() {
        if (isMockServerEnable()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }



    fun stopMockServer() {
        if (isMockServerEnable())
            mockServer.shutdown()
    }

    @Before
    open fun setup(){
        startMockServer()
    }


    open fun mockHttpresponse(filename: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJson(filename))
    )

    fun mockHttpResponse(mockResponse: MockResponse) = mockServer.enqueue(mockResponse)

    fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

        @After
    open fun teardown() {
        stopMockServer()
    }

    abstract fun isMockServerEnable(): Boolean
}