package com.business.serviceImpl;

import com.business.domain.Course;
import com.business.pojo.CoursePojo;
import com.business.repository.CourseRepo;
import com.business.service.CourseService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseRepo> getListCourseByActivityId(Long activityId) {
        return BeanMapper.mapList(courseRepo.findByActivityId(activityId), CourseRepo.class);
    }

    @Override
    public CoursePojo getCoursePojo(Long activityId, String courseName) {
        return BeanMapper.map(courseRepo.findByActivityIdAndCourseName(activityId, courseName), CoursePojo.class);
    }

    @Override
    public Course getCourse(Long activityId, String courseName) {
        return courseRepo.findByActivityIdAndCourseName(activityId, courseName);
    }
}
