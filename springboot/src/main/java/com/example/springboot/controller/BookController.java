package com.example.springboot.controller;

import com.example.springboot.entity.Book;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/{isbn}")
    public Book getBookByISBN(@PathVariable("isbn") String isbn) {
        return bookService.findBookByISBN(isbn);
    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBookByISBN(isbn);
    }
}
