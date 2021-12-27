package com.company.service.impl;

import com.company.dao.AuthorDao;
import com.company.dto.AuthorDto;
import com.company.entity.Author;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.results.SuccessDataResult;
import com.company.service.AuthorService;
import com.company.service.adapter.AuthorAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorAdapter authorAdapter;
    private final AuthorDao authorDao;

    @Override
    @Transactional
    public Result addAuthor(AuthorDto authorDto) {
        authorDao.addAuthor(authorAdapter.map(authorDto));
        return new Result(true, "successfully added");
    }

    @Override
    @Transactional
    public Result deleteAuthor(Integer authorId) {
        authorDao.deleteAuthor(authorId);
        return new Result(true, "successfully deleted");
    }

    @Override
    @Transactional
    public DataResult<AuthorDto> findByUsername(String username) {
        Author author = authorDao.findByUsername(username);
        return new SuccessDataResult<>(authorAdapter.map(author));
    }

    @Override
    @Transactional
    public Long countAuthor() {
        return authorDao.countAuthor();
    }
}
