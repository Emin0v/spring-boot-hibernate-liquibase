package com.company.service;

import com.company.dto.BookDto;
import com.company.results.DataResult;
import com.company.results.Result;

import java.util.List;

public interface BookService {

    Result addBook(BookDto bookDto);

    DataResult<BookDto> findById(Integer id);

    DataResult<List<BookDto>> getAllBooksSorted();

    DataResult<List<BookDto>> getBooksByUsername(String username);

    Long countBooks();
}
