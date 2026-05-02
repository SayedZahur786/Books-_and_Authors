package com.example.bookmgmt.controller;

import com.example.bookmgmt.model.Author;
import com.example.bookmgmt.model.Book;
import com.example.bookmgmt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", bookService.getAllAuthors());
        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            return "redirect:/books/add?error=IntegrityViolation";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("authors", bookService.getAllAuthors());
            return "book-form";
        }
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
