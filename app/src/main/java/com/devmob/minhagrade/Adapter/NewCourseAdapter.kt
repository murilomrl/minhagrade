package com.devmob.minhagrade.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.devmob.minhagrade.Model.Course
import com.devmob.minhagrade.R

class NewCourseAdapter(internal var context: Context, internal var resultListCourse: List<Course>) : RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        var itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.spinner_curso, parent,false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.nomeCurso.text = resultListCourse[position].getNome().toString()
    }

    override fun getItemCount(): Int {
        return resultListCourse.size
    }
}