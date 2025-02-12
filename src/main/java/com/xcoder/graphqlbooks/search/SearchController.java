package com.xcoder.graphqlbooks.search;

import java.util.ArrayList;
import java.util.List;

import com.xcoder.graphqlbooks.author.AuthorRepository;
import com.xcoder.graphqlbooks.book.Book;
import com.xcoder.graphqlbooks.book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public SearchController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    List<Object> search(@Argument String text) {
        log.debug("Searching for '{}'", text);
        List<Object> result = new ArrayList<>();
        result.addAll(authorRepository.findAllByNameContainsIgnoreCase(text));
        result.addAll(bookRepository.findAllByTitleContainsIgnoreCase(text));
        return result;
    }
}
