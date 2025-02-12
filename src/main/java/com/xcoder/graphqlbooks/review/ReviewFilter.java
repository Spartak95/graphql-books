package com.xcoder.graphqlbooks.review;

public record ReviewFilter(Integer rating, Boolean verified, String reviewerName) {
}
