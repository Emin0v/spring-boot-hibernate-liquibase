package com.company.controller;

import com.company.dto.BookDto;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Result> addBook(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.addBook(bookDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<BookDto>> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<BookDto>>> getAllBooksSorted(){
        return ResponseEntity.ok(bookService.getAllBooksSorted());
    }

    @GetMapping("author/{username}")
    public ResponseEntity<DataResult<List<BookDto>>> getBooksByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(bookService.getBooksByUsername(username));
    }

}
