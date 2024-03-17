package com.example.springboot.service.impl;

import com.example.springboot.entity.Book;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book findBookByISBN(String isbn) {
        return bookMapper.findByISBN(isbn);
    }

    @Override
    public void saveBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void deleteBookByISBN(String isbn) {
        bookMapper.deleteByISBN(isbn);
    }
}
