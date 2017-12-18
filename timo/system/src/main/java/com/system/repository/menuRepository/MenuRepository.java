package com.system.repository.menuRepository;

import com.system.domain.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/18.
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    /**
     * 根据root查找
     * @param root
     * @return
     */
    List<Menu> findBySubMenu(String root);

}
