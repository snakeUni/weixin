package com.business.repository;

import com.business.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    /**
     * 根据活动id来查找
     * @param activityId
     * @return
     */
    List<Course> findByActivityId(Long activityId);

    /**
     * 根据Id和课程名称找到唯一
     * @param activityId
     * @param courseName
     * @return
     */
    Course findByActivityIdAndCourseName(Long activityId, String courseName);

}
