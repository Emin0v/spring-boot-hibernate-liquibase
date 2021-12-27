package com.company.service;

import com.company.dto.AuthorDto;
import com.company.results.DataResult;
import com.company.results.Result;

public interface AuthorService {

    Result addAuthor(AuthorDto authorDto);

    Result deleteAuthor(Integer authorId);

    DataResult<AuthorDto> findByUsername(String username);

    Long countAuthor();
}
