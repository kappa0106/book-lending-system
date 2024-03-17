package com.example.springboot.controller;

import com.example.springboot.entity.Borrow;
import com.example.springboot.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

    @GetMapping("/{recordId}")
    public Borrow getBorrowByRecordId(@PathVariable("recordId") Long recordId) {
        return borrowService.findBorrowByRecordId(recordId);
    }

    @PostMapping("/")
    public void addBorrow(@RequestBody Borrow borrow) {
        borrowService.saveBorrow(borrow);
    }

    @PutMapping("/")
    public void updateBorrow(@RequestBody Borrow borrow) {
        borrowService.updateBorrow(borrow);
    }

    @DeleteMapping("/{recordId}")
    public void deleteBorrow(@PathVariable("recordId") Long recordId) {
        borrowService.deleteBorrowByRecordId(recordId);
    }
}
