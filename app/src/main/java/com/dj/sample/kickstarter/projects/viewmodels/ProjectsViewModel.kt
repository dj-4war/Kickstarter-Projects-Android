package com.dj.sample.kickstarter.projects.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dj.sample.kickstarter.projects.models.Project
import com.dj.sample.kickstarter.projects.repositories.IProjectsRepo
import com.dj.sample.kickstarter.projects.repositories.ProjectsRepoImpl

class ProjectsViewModel(private val projectsRepo : IProjectsRepo) : ViewModel(){
    fun getProjects() : MutableLiveData<List<Project>>{
        return projectsRepo.getProjectsFromRemote()
    }
}