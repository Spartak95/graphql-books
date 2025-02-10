package com.xcoder.graphqlbooks.review;

import java.time.LocalDateTime;

import com.xcoder.graphqlbooks.book.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
    private String reviewerName;
    private Boolean verified;
    private Book book;
}
