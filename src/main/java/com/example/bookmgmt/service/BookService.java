package com.example.bookmgmt.service;

import com.example.bookmgmt.model.Author;
import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.repository.AuthorRepository;
import com.example.bookmgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllBooksWithAuthors();
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
