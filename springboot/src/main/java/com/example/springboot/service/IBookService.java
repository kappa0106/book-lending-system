package com.example.springboot.service;

import com.example.springboot.entity.Book;

public interface IBookService {
    Book findBookByISBN(String isbn);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBookByISBN(String isbn);
}
