package com.company.service.adapter;

import com.company.dto.BookDto;
import com.company.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookAdapter {

    BookDto map(Book book);

    List<BookDto> mapToDtoList(List<Book> bookList);

    @Mapping(target = "author", ignore = true)
    Book map(BookDto bookDto);

    List<Book> mapToBookList(List<BookDto> bookList);

}
