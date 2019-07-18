package com.dj.sample.kickstarter.projects.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import com.dj.sample.kickstarter.projects.adapters.ProjectsListAdapter
import com.dj.sample.kickstarter.projects.models.Project
import com.dj.sample.kickstarter.projects.utils.ConnectionUtils
import com.dj.sample.kickstarter.projects.viewmodels.ProjectsViewModel
import kotlinx.android.synthetic.main.activity_projectlist.*
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.getViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dj.sample.kickstarter.projects.R
import com.dj.sample.kickstarter.projects.utils.KickstarterLogger


/**
 * Activity to list the Projects and perform required operations on screen,.
 */
class ProjectListActivity : KickstarterBaseActivity() {
    private val TAG : String = ProjectListActivity::javaClass.name
    private lateinit var mProjectList: MutableList<Project>
    private lateinit var mProjectListAdapter : ProjectsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projectlist)
        init();
        setupUI()
        getProjects()
    }

    private fun setupUI() {
        project_list_rv.adapter = mProjectListAdapter
        val manager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        project_list_rv.layoutManager = manager
        supportActionBar!!.elevation = 0.0F
    }
    private fun init() {
        mProjectList = mutableListOf()
        mProjectListAdapter = ProjectsListAdapter(this, mProjectList)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)//Menu Resource, Menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.main_action_search ->{} //TODO

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getProjects() {
        val connectionUtils: ConnectionUtils = get()
        if (connectionUtils.isConnectedToNetwork()) {
            loading_pb.visibility = View.VISIBLE
            getViewModel<ProjectsViewModel>().getProjects().observe(this, Observer { projectsList ->
                if (projectsList != null) {
                    KickstarterLogger.infoLog(TAG, "getProjects() :: Projects sise ${projectsList.size}")
                    mProjectList.clear()
                    mProjectList.addAll(projectsList)
                    mProjectListAdapter.notifyDataSetChanged()
                    loading_pb.visibility = View.GONE
                } else {
                    showSnackBar("Something went wrong", true, true, content)
                }
            })
        } else {
            showSnackBar("No internet connection!", true, true, content)
        }
    }
}
