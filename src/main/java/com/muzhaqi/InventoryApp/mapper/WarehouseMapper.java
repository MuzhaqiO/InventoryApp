package com.muzhaqi.InventoryApp.mapper;

import com.muzhaqi.InventoryApp.dto.warehouseDTO.WarehouseEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Warehouse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    WarehouseEntityResponseDTO toDTO (Warehouse warehouse);
    List<WarehouseEntityResponseDTO> toDTOs (List<Warehouse> warehouses);
    Warehouse toEntity (WarehouseEntityResponseDTO warehouseEntityResponseDTO);
    List<Warehouse> toEntities (List<WarehouseEntityResponseDTO> warehouseEntityResponseDTOs);
}
