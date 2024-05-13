package com.muzhaqi.InventoryApp.controller;

import com.muzhaqi.InventoryApp.dto.productDTO.ProductEntityResponseDTO;
import com.muzhaqi.InventoryApp.dto.warehouseDTO.WarehouseEntityResponseDTO;
import com.muzhaqi.InventoryApp.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inventoryApp/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping("warehouseId/{id}")
    public ResponseEntity<WarehouseEntityResponseDTO> getWarehouseById(@PathVariable Long id){
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<WarehouseEntityResponseDTO>> getAllWarehouses(){
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }
    @PostMapping("updateWarehouse/{id}")
    public ResponseEntity<WarehouseEntityResponseDTO> updateQuantity(@PathVariable Long id, @RequestParam Long quantity){
        return ResponseEntity.ok(warehouseService.updateQuantity(id, quantity));
    }
}
