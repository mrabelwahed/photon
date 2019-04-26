package com.ramadan.photon.base

import com.ramadan.photon.common.BASE_URL
import com.ramadan.photon.di.*
import com.ramadan.photon.ui.viewmodel.ViewModelFactory
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File
import javax.inject.Inject

abstract class BaseTest {

    lateinit var mockServer: MockWebServer
    lateinit var testAppComponent: TestAppComponent
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Before
    open fun setup() {
        configureMockServer()
        configureDI()
    }

     fun configureDI(){
        testAppComponent =  DaggerTestAppComponent.builder()
            .networkModule(NetworkModule(if (isMockServerEnable()) mockServer.url("/").toString() else BASE_URL))
            .testRxJavaModule(TestRxJavaModule())
            .repositoryModule(RepositoryModule())
            .build()
         testAppComponent.inject(this)
     }


    @After
    open fun teardown() {
        stopMockServer()
    }


    fun configureMockServer() {
        if (isMockServerEnable()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }




    fun stopMockServer() {
        if (isMockServerEnable())
            mockServer.shutdown()
    }


    open fun mockHttpresponse(filename:String , responseCode:Int) = mockServer.enqueue(MockResponse()
        .setResponseCode(responseCode)
        .setBody(getJson(filename)))


    fun getJson(path:String):String{
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

    abstract fun isMockServerEnable(): Boolean
}