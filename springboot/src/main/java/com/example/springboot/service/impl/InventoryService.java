package com.example.springboot.service.impl;

import com.example.springboot.entity.Inventory;
import com.example.springboot.mapper.InventoryMapper;
import com.example.springboot.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public Inventory findInventoryByInventoryId(Long inventoryId) {
        return inventoryMapper.findByInventoryId(inventoryId);
    }

    @Override
    public void saveInventory(Inventory inventory) {
        inventoryMapper.save(inventory);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryMapper.update(inventory);
    }

    @Override
    public void deleteInventoryByInventoryId(Long inventoryId) {
        inventoryMapper.deleteByInventoryId(inventoryId);
    }
}
