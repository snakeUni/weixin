package com.business.utils;

import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Uni on 2017/7/9.
 */
public class BeanMapper {

    private static DozerBeanMapper dozer = new DozerBeanMapper();

    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozer.map(source, destinationClass);
    }

    @SuppressWarnings("rawtypes")
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public static void copy(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }

    public static <T, K> Page<T> mapPage(Page<K> sourcePage, Class<T> destinationPageItemClass) {
        if (sourcePage == null) {
            return null;
        }
        PageImpl<T> pageable = (PageImpl<T>)sourcePage;
        return new PageImpl<T>(mapList(sourcePage.getContent(),destinationPageItemClass),new PageRequest(pageable.getNumber(),pageable.getSize() > 0?pageable.getSize():10),sourcePage.getTotalElements());
    }

}
