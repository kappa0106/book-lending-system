package com.example.springboot.mapper;

import com.example.springboot.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorrowMapper {
    Borrow findByRecordId(Long recordId);
    void save(Borrow borrow);
    void update(Borrow borrow);
    void deleteByRecordId(Long recordId);
}
