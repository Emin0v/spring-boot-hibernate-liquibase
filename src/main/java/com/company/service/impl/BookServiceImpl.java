package com.company.service.impl;

import com.company.dao.AuthorDao;
import com.company.dao.BookDao;
import com.company.dto.BookDto;
import com.company.entity.Author;
import com.company.entity.Book;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.results.SuccessDataResult;
import com.company.service.BookService;
import com.company.service.adapter.BookAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final BookAdapter bookAdapter;

    @Override
    @Transactional
    public Result addBook(BookDto bookDto) {
//        Book book = bookAdapter.map(bookDto);
        Book book = Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName()).build();
        Author author = authorDao.findById(bookDto.getAuthorId());
        book.setAuthor(author);
        bookDao.addBook(book);
        return new Result(true,"successfully added");
    }

    @Override
    @Transactional
    public DataResult<BookDto> findById(Integer id) {
        Book book = bookDao.findById(id);
        return new SuccessDataResult<>(bookAdapter.map(book),"Successfully process");
    }

    @Override
    @Transactional
    public DataResult<List<BookDto>> getAllBooksSorted() {
        List<Book> books = bookDao.getAllBooksSorted();
        return new SuccessDataResult<>(bookAdapter.mapToDtoList(books),"successfully sorted");
    }

    @Override
    @Transactional
    public DataResult<List<BookDto>> getBooksByUsername(String username) {
        List<Book> books = bookDao.getBooksByUsername(username);

        return new SuccessDataResult<>(bookAdapter.mapToDtoList(books),"successfully process");
    }

    @Override
    @Transactional
    public Long countBooks() {
        return bookDao.countBooks();
    }

}
