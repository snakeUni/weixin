package com.business.serviceImpl;

import com.business.domain.Activity;
import com.business.pojo.ActivityPojo;
import com.business.repository.ActivityRepo;
import com.business.service.ActivityService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public ActivityPojo getActivityByTitle(String title) {
        Activity activity = activityRepo.findByTitle(title);
        return BeanMapper.map(activity, ActivityPojo.class);
    }
}
