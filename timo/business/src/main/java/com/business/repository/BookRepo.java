package com.business.repository;

import com.business.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    /**
     * 根据courseId
     * @param courseId
     * @return
     */
    List<Book> findByCourseId(Long courseId);

    /**
     * 根据书名
     * @param name
     * @return
     */
    Book findByName(String name);

}
