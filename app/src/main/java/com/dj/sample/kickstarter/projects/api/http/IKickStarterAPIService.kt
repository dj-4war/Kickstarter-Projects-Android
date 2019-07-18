package com.dj.sample.kickstarter.projects.api.http

import com.dj.sample.kickstarter.projects.models.Project
import retrofit2.Call
import retrofit2.http.GET

/**
 * API service interface to call APIs from consume server APIs.
 */

interface IKickStarterAPIService{

    /**
     * API to get the projects from Kickstarter
     */
    @GET("$BASE_URL/kickstarter")
    fun getProjects(): Call<List<Project>>

}

