package com.example.bookmgmt.service;

import com.example.bookmgmt.model.Author;
import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.repository.AuthorRepository;
import com.example.bookmgmt.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        Author author = new Author("Author", "Nationality");
        Book book = new Book("Title", "ISBN", 10.0, author);
        
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Arrays.asList(book));

        List<Book> result = bookService.getAllBooks();
        
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Title");
    }
}
