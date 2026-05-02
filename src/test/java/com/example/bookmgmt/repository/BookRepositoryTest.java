package com.example.bookmgmt.repository;

import com.example.bookmgmt.model.Author;
import com.example.bookmgmt.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllBooksWithAuthors() {
        Author author = new Author("Test Author", "Testland");
        author = authorRepository.save(author);
        
        Book book = new Book("Test Book", "12345", 10.0, author);
        bookRepository.save(book);

        List<Book> books = bookRepository.findAllBooksWithAuthors();
        
        assertThat(books).isNotEmpty();
        assertThat(books.get(0).getAuthor().getName()).isEqualTo("Test Author");
    }
}
