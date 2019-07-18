package com.dj.sample.kickstarter.projects.api.http

import retrofit2.Retrofit


interface
IHTTPClient{
    fun bindService(service: Any) : Any
    fun getHttpClient() : Retrofit?
}