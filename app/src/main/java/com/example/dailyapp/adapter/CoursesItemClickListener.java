/*
 * Copyright (c) 2020. rogergcc
 */

package com.example.dailyapp.adapter;

import android.widget.ImageView;

import com.example.dailyapp.model.CourseCard;

public interface CoursesItemClickListener {

    void onDashboardCourseClick(CourseCard courseCard, ImageView imageView); // Shoud use imageview to make the shared animation between the two activity

}
