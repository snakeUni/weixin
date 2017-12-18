package com.business.repository;

import com.business.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long>{

    /**
     * 根据名称查找
     * @param title
     * @return
     */
    Activity findByTitle(String title);

}
