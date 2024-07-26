package com.muzhaqi.InventoryApp.service;

import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionCreateDTO;
import com.muzhaqi.InventoryApp.dto.warehouseDTO.WarehouseEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import com.muzhaqi.InventoryApp.enums.Type;
import com.muzhaqi.InventoryApp.mapper.WarehouseMapper;
import com.muzhaqi.InventoryApp.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    public WarehouseEntityResponseDTO getWarehouseById (Long id){
        return warehouseMapper.toDTO(warehouseRepository.getReferenceById(id));
    }

    public List<WarehouseEntityResponseDTO> getAllWarehouses(){
        return warehouseMapper.toDTOs(warehouseRepository.findAll());
    }

    public WarehouseEntityResponseDTO updateQuantity (Long id, Long quantity){
        Warehouse warehouse = warehouseRepository.getReferenceById(id);
        warehouse.setQuantity(quantity);
        return warehouseMapper.toDTO(warehouseRepository.save(warehouse));
    }

    public void updateProductQuantity (TransactionCreateDTO transactionCreateDTO, Type billType){
        Warehouse warehouse = warehouseRepository.getReferenceById(transactionCreateDTO.getProductId());
        long quantityChange = transactionCreateDTO.getQuantity() * (billType == Type.SELL ? -1:1);
         long newQuantity = warehouse.getQuantity() + quantityChange;
         warehouse.setQuantity(newQuantity);
         warehouseRepository.save(warehouse);
    }
}
