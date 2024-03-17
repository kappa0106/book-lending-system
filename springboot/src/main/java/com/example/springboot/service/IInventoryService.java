package com.example.springboot.service;

import com.example.springboot.entity.Inventory;

public interface IInventoryService {
    Inventory findInventoryByInventoryId(Long inventoryId);
    void saveInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    void deleteInventoryByInventoryId(Long inventoryId);
}