package com.example.springboot.service;

import com.example.springboot.entity.Borrow;

public interface IBorrowService {
    Borrow findBorrowByRecordId(Long recordId);
    void saveBorrow(Borrow borrow);
    void updateBorrow(Borrow borrow);
    void deleteBorrowByRecordId(Long recordId);
}
