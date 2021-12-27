package com.company.dao;

import com.company.dto.BookDto;
import com.company.entity.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    Book findById(Integer id);

    List<Book> getAllBooksSorted();

    List<Book> getBooksByUsername(String username);

    Long countBooks();

}
