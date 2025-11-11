package com.crud.demo.book.Repository;

import com.crud.demo.book.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BookRepository extends JpaRepository<BookModel,Long> {
}
