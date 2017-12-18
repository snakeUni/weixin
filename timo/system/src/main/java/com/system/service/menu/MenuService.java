package com.system.service.menu;

import com.system.domain.menu.Menu;
import com.system.pojo.menu.MenuData;

import java.util.List;

/**
 * Created by Uni on 2017/11/18.
 */
public interface MenuService {

    /**
     * 根据root返回信息
     * @param root
     * @return
     */
    List<MenuData> getByRoot(String root);

    /**
     * 返回实体类方便保存
     * @param root
     * @return
     */
    List<Menu> getByRoots(String root);

}
