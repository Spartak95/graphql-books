package com.xcoder.graphqlbooks.book;

import java.util.List;
import java.util.Optional;

import com.xcoder.graphqlbooks.author.Author;
import com.xcoder.graphqlbooks.author.AuthorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Optional<Book> book(@Argument Long id) {
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {
        Optional<Author> author = authorRepository.findById(bookInput.authorId());
        Book book = new Book();
        book.setTitle(bookInput.title());
        book.setAuthor(author.orElseThrow());
        return bookRepository.save(book);
    }
}
