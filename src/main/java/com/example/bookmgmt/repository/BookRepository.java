package com.example.bookmgmt.repository;

import com.example.bookmgmt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b JOIN b.author a")
    List<Book> findAllBooksWithAuthors();
}
