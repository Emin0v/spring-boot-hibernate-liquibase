package com.company.service.adapter;

import com.company.dto.AuthorDto;
import com.company.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorAdapter {

    AuthorDto map(Author author);

    Author map(AuthorDto authorDto);

}
