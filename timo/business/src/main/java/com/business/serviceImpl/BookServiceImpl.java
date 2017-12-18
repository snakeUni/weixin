package com.business.serviceImpl;

import com.business.pojo.BookPojo;
import com.business.repository.BookRepo;
import com.business.service.BookService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<BookPojo> getBookListByCourseid(Long courseId) {
        return BeanMapper.mapList(bookRepo.findByCourseId(courseId), BookPojo.class);
    }

    @Override
    public BookPojo getBookByBookName(String name) {
        return BeanMapper.map(bookRepo.findByName(name), BookPojo.class);
    }
}
