package com.system.serviceImpl.menu;

import com.system.domain.menu.Menu;
import com.system.pojo.menu.MenuData;
import com.system.repository.menuRepository.MenuRepository;
import com.system.service.menu.MenuService;
import com.system.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/18.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuData> getByRoot(String root) {
        List<Menu> menus = menuRepository.findBySubMenu(root);
        return BeanMapper.mapList(menus, MenuData.class);
    }

    @Override
    public List<Menu> getByRoots(String root) {
        return menuRepository.findBySubMenu(root);
    }
}
