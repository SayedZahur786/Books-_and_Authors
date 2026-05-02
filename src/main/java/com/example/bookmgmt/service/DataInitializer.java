package com.example.bookmgmt.service;

import com.example.bookmgmt.model.Author;
import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.repository.AuthorRepository;
import com.example.bookmgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Populate 10 Authors
        String[] names = {"J.K. Rowling", "George R.R. Martin", "J.R.R. Tolkien", "Stephen King", "Agatha Christie", 
                          "Ernest Hemingway", "Mark Twain", "Charles Dickens", "Leo Tolstoy", "Jane Austen"};
        String[] nationalities = {"British", "American", "British", "American", "British", 
                                  "American", "American", "British", "Russian", "British"};

        for (int i = 0; i < 10; i++) {
            Author author = new Author(names[i], nationalities[i]);
            author = authorRepository.save(author);

            // Populate 10 Books (one for each author for simplicity, or multiple)
            Book book = new Book("Book Title " + (i + 1), "ISBN-" + (1000 + i), 19.99 + i, author);
            bookRepository.save(book);
        }
    }
}
