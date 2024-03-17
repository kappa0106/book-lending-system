package com.example.springboot.mapper;

import com.example.springboot.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryMapper {
    Inventory findByInventoryId(Long inventoryId);
    void save(Inventory inventory);
    void update(Inventory inventory);
    void deleteByInventoryId(Long inventoryId);
}
