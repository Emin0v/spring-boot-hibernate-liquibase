package com.company.dao;

import com.company.entity.Author;

public interface AuthorDao {

    Author findById(Integer id);

    void addAuthor(Author author);

    void deleteAuthor(Integer authorId);

    Author findByUsername(String username);

    Long countAuthor();

}
