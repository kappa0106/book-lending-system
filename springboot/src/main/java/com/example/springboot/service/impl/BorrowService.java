package com.example.springboot.service.impl;

import com.example.springboot.entity.Borrow;
import com.example.springboot.mapper.BorrowMapper;
import com.example.springboot.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public Borrow findBorrowByRecordId(Long recordId) {
        return borrowMapper.findByRecordId(recordId);
    }

    @Override
    public void saveBorrow(Borrow borrow) {
        borrowMapper.save(borrow);
    }

    @Override
    public void updateBorrow(Borrow borrow) {
        borrowMapper.update(borrow);
    }

    @Override
    public void deleteBorrowByRecordId(Long recordId) {
        borrowMapper.deleteByRecordId(recordId);
    }
}
