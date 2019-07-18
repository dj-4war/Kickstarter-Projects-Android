package com.dj.sample.kickstarter.projects.api.http

import com.dj.sample.kickstarter.projects.BuildConfig
import com.dj.sample.kickstarter.projects.utils.KickstarterLogger
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


/**
 * Factory class for creation of the Api Service interface
 */
object KickstarterHTTPClient : IHTTPClient {

    private val TAG: String = KickstarterHTTPClient::class.java.name
    private var mRetroClient: Retrofit? = null

    override fun getHttpClient(): Retrofit? {
        if (mRetroClient == null) {
            createHTTPClient()
        }
        return mRetroClient
    }

    override fun bindService(service: Any): Any {
        if (mRetroClient == null) {
            createHTTPClient()
        }
        return mRetroClient!!.create(service::class.java)
    }

    fun initialize() {
        if (mRetroClient == null) {
            createHTTPClient()
        } else {
            KickstarterLogger.infoLog(TAG, "initialize() :: Base URL cannot be null")
        }
    }

    private fun createHTTPClient(): Retrofit? {
        KickstarterLogger.infoLog(TAG, "createHTTPClient() :: Creating Retrofit HTTP client")

        KickstarterLogger.infoLog(TAG, "createHTTPClient() :: Base URL -->" + HttpUrl.parse(BASE_URL))

        // OkHTTPLogging Logging
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)  // If app is type of Debug we expose logs, for the production builds we never expose
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        else
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
            .build()

        mRetroClient = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
        return mRetroClient
    }
}