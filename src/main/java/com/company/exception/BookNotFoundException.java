package com.company.exception;

public class BookNotFoundException extends NotFoundException{

    private static final String BOOK_NOT_FOUND = "Book not found";

    public BookNotFoundException(String name){
        super(String.format("Book \"%s\" not found", name));
    }

    public BookNotFoundException(){
        super(BOOK_NOT_FOUND);
    }
}
