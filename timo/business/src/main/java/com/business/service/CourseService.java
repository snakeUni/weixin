package com.business.service;

import com.business.domain.Course;
import com.business.pojo.CoursePojo;
import com.business.repository.CourseRepo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface CourseService {

    List<CourseRepo> getListCourseByActivityId(Long activityId);

    CoursePojo getCoursePojo(Long activityId, String courseName);

    Course getCourse(Long activityId, String courseName);
}
