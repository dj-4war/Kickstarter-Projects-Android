package com.dj.sample.kickstarter.projects.repositories

import androidx.lifecycle.MutableLiveData
import com.dj.sample.kickstarter.projects.models.Project

interface IProjectsRepo{
    fun getProjectsFromRemote() : MutableLiveData<List<Project>>
}