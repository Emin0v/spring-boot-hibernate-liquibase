package com.company.controller;

import com.company.dto.AuthorDto;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Result> addAuthor(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorService.addAuthor(authorDto));
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Result> deleteAuthor(@PathVariable("authorId") Integer authorId){
        return ResponseEntity.ok(authorService.deleteAuthor(authorId));
    }

    @GetMapping("/{username}")
    public ResponseEntity<DataResult<AuthorDto>> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(authorService.findByUsername(username));
    }

}
