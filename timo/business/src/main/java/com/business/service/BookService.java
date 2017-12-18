package com.business.service;

import com.business.pojo.BookPojo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface BookService {

    List<BookPojo> getBookListByCourseid(Long courseId);

    BookPojo getBookByBookName(String name);

}
