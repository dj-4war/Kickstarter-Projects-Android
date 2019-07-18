package com.dj.sample.kickstarter.projects.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dj.sample.kickstarter.projects.R
import com.dj.sample.kickstarter.projects.models.Project
import com.dj.sample.kickstarter.projects.ui.activities.ProjectDetailsActivity


class ProjectsListAdapter(context: Context, callMessageList: MutableList<Project>) :
    RecyclerView.Adapter<ViewHolder>() {

    private val TAG = ProjectsListAdapter::class.java.canonicalName
    private var mProjectList: MutableList<Project> = ArrayList()
    private var mContext: Context

    init {
        mContext = context
        this.mProjectList = callMessageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.project_list_rv_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mProjectList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = mProjectList[position]
        if (project != null) {
            holder.projectName.text = project.getTitle()
            holder.projectCost.text = project.getAmtPledged().toString()
            holder.currency.text =  project.getCurrency()
        }
        holder.rootCard.setOnClickListener {
            val projectDetailsIntent = Intent(mContext, ProjectDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("project_details", project)
            projectDetailsIntent.putExtras(bundle)
            mContext.startActivity(projectDetailsIntent)
        }
    }
}


class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var projectName = view.findViewById<TextView>(R.id.project_title_tv)
    var projectCost = view.findViewById<TextView>(R.id.project_cost)
    var currency = view.findViewById<TextView>(R.id.project_currecy_tv)
    var rootCard = view.findViewById<CardView>(R.id.project_card_view)
}