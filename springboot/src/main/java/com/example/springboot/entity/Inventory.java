package com.example.springboot.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId; 
    private String isbn;
    private LocalDateTime storeTime;
    private String status;
    
    public Long getId() {
        return inventoryId;
    }
    public void setId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }
    
    public String getISBN() {
        return isbn;
    }
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    
    public LocalDateTime getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(LocalDateTime storeTime) {
        this.storeTime = storeTime;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
