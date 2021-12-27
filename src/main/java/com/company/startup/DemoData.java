package com.company.startup;

import com.company.dto.AuthorDto;
import com.company.dto.BookDto;
import com.company.service.AuthorService;
import com.company.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@Component
public class DemoData {

    private final BookService bookService;
    private final AuthorService authorService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = authorService.countAuthor();
        assert countOfData!=null;
        if(countOfData.equals(0L)){
            IntStream.range(0,5).forEach(item->{

                authorService.addAuthor(
                        AuthorDto.builder()
                                .name("Author"+item)
                                .username("author."+item)
                                .build()
                );

            });
        }
    }

}
