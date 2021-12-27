package com.company.exception;

public class AuthorNotFoundException extends NotFoundException{

    private static final String AUTHOR_NOT_FOUND = "Author not found";

    public AuthorNotFoundException(String username) {
        super(String.format("Author \"%s\" not found", username));
    }

    public AuthorNotFoundException() {
        super(AUTHOR_NOT_FOUND);
    }
}
