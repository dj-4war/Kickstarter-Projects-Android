package com.dj.sample.kickstarter.projects.integration

import com.dj.sample.kickstarter.projects.BaseTestClass
import com.dj.sample.kickstarter.projects.api.http.IKickStarterAPIService
import com.dj.sample.kickstarter.projects.api.http.KickstarterHTTPClient
import com.dj.sample.kickstarter.projects.models.Project
import com.dj.sample.kickstarter.projects.utils.KickstarterLogger
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

/**
 * This is class holds Kickstarter integration tests and this class is responsible to test APIs and its behaviour
 * @author Shashi, Created at July 18nd 2019
 */
@RunWith(MockitoJUnitRunner::class)
class ProjectsAPIIntegrationTest : BaseTestClass() {

    val TAG: String = ProjectsAPIIntegrationTest::class.java.name

    init {
        KickstarterHTTPClient.initialize()
    }

    @Test
    fun canHitPubProjectsEndPoint() {
        val response = hitProjectsEndPoint()
        assertEquals(response.code(), 200)
    }

    @Test
    fun canGetProjects(){
        val response = hitProjectsEndPoint()
        val projectsSize = response.body()?.size
        KickstarterLogger.infoLog(TAG, "Projects list size $projectsSize")
        assertNotNull(response.body())
    }


    private fun hitProjectsEndPoint(): retrofit2.Response<List<Project>> {
        val projectsAPI: IKickStarterAPIService =
            KickstarterHTTPClient.getHttpClient()!!.create(IKickStarterAPIService::class.java)  // Get API service
        val projects = projectsAPI.getProjects()
        return projects.execute()
    }
}
