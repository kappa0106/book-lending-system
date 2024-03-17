package com.example.springboot.mapper;

import com.example.springboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    Book findByISBN(String isbn);
    void save(Book book);
    void update(Book book);
    void deleteByISBN(String isbn);
}
