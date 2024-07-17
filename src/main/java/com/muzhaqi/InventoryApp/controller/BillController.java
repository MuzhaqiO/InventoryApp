package com.muzhaqi.InventoryApp.controller;

import com.muzhaqi.InventoryApp.dto.billDTO.BillCreateDTO;
import com.muzhaqi.InventoryApp.dto.billDTO.BillEntityResponseDTO;
import com.muzhaqi.InventoryApp.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "inventoryApp/bill")
@RequiredArgsConstructor
public class  BillController {
    private final BillService billService;

    @GetMapping("billId/{id}")
    public ResponseEntity<BillEntityResponseDTO> getBillById(@PathVariable Long id){
        return ResponseEntity.ok(billService.getBillById(id));
    }
    @GetMapping("getAll")
    public ResponseEntity<List<BillEntityResponseDTO>> getAllBills(){
        return ResponseEntity.ok(billService.getBills());
    }
    @PostMapping("createBill")
    public ResponseEntity<BillEntityResponseDTO> createBill(@RequestBody BillCreateDTO billCreateDTO){
        return ResponseEntity.ok(billService.createBill(billCreateDTO));
    }
}
