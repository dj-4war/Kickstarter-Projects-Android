package com.dj.sample.kickstarter.projects.repositories

import androidx.lifecycle.MutableLiveData
import com.dj.sample.kickstarter.projects.api.http.IKickStarterAPIService
import com.dj.sample.kickstarter.projects.api.http.KickstarterHTTPClient
import com.dj.sample.kickstarter.projects.models.Project
import com.dj.sample.kickstarter.projects.utils.KickstarterLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectsRepoImpl: IProjectsRepo {

    private val TAG: String = ProjectsRepoImpl::javaClass.name

    override fun getProjectsFromRemote() : MutableLiveData<List<Project>> {
        val projectList : MutableLiveData<List<Project>> = MutableLiveData()
        try {
            val kickStartAPI: IKickStarterAPIService =
                KickstarterHTTPClient.getHttpClient()!!.create(IKickStarterAPIService::class.java)  // Get API service
            val projectsResponse = kickStartAPI.getProjects()
            projectsResponse.enqueue(
                object : Callback<List<Project>> {
                    override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                        KickstarterLogger.errLog(TAG, "onFailure() :: Failed to get response ", null);
                    }

                    override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                        if(response.isSuccessful) {
                            projectList.value = response.body()
                        }
                    }
                })

        } catch (ex: Exception) {
            KickstarterLogger.errLog(TAG, "getProjectsFromRemote() :: Exception in getProjectsFromRemote ", ex)
        }
        return projectList
    }

}