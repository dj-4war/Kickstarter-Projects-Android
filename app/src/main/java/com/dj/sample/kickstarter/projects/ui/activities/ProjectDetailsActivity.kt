package com.dj.sample.kickstarter.projects.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity;
import com.dj.sample.kickstarter.projects.R
import com.dj.sample.kickstarter.projects.api.http.BASE_URL
import com.dj.sample.kickstarter.projects.models.Project

import kotlinx.android.synthetic.main.activity_project_details.*



class ProjectDetailsActivity : AppCompatActivity() {

    private lateinit var mSelectedProject : Project

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_details)
        init()
        setupUI()

    }

    private fun init() {
        val extras = intent.extras
        mSelectedProject = extras!!.getSerializable("project_details") as Project
    }

    private fun setupUI() {
        supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        project_details_title_tv.text = mSelectedProject.getTitle()
        project_details_pledged_tv.text = mSelectedProject.getAmtPledged().toString()
        project_details_blurb_tv.text = mSelectedProject.getBlurb()
        project_details_by_tv.text = "by : "+mSelectedProject.getBy()
        project_details_country_tv.text = "Country : "+mSelectedProject.getCountry()
        project_details_currency_tv.text = "Currency : "+mSelectedProject.getCurrency()
        project_details_funded_tv.text = "% Funded : "+mSelectedProject.getPercentageFunded().toString()
        project_details_backers_tv.text = "# Backers : "+mSelectedProject.getNumBackers()
        project_details_url_tv.text = BASE_URL+mSelectedProject.getUrl()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
