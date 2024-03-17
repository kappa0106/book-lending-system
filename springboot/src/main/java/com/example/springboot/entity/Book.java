package com.example.springboot.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
    private String isbn; // primary key
    private String name;
    private String author;
    private String introduction;
    
    public String getISBN() {
        return isbn;
    }
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
}
