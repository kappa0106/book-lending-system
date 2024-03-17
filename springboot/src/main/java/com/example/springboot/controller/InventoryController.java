package com.example.springboot.controller;

import com.example.springboot.entity.Inventory;
import com.example.springboot.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @GetMapping("/{inventoryId}")
    public Inventory getInventoryByInventoryId(@PathVariable("inventoryId") Long inventoryId) {
        return inventoryService.findInventoryByInventoryId(inventoryId);
    }

    @PostMapping("/")
    public void addInventory(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
    }

    @PutMapping("/")
    public void updateInventory(@RequestBody Inventory inventory) {
        inventoryService.updateInventory(inventory);
    }

    @DeleteMapping("/{inventoryId}")
    public void deleteInventory(@PathVariable("inventoryId") Long inventoryId) {
        inventoryService.deleteInventoryByInventoryId(inventoryId);
    }
}
