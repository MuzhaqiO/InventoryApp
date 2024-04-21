package com.muzhaqi.InventoryApp.mapper;

import com.muzhaqi.InventoryApp.dto.billDTO.BillCreateDTO;
import com.muzhaqi.InventoryApp.dto.billDTO.BillEntityResponseDTO;
import com.muzhaqi.InventoryApp.dto.billDTO.BillTransactionDTO;
import com.muzhaqi.InventoryApp.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillCreateDTO toCreateDTO (Bill bill);
    List<BillCreateDTO> toCreateDTOs (List<Bill> bills);
    Bill toCreateEntity (BillCreateDTO billCreateDTO);
    List<Bill> toCreateEntities (List<BillCreateDTO> billCreateDTOs);

    BillEntityResponseDTO toDTO (Bill bill);
    List<BillEntityResponseDTO> toDTOs (List<Bill> bills);
    Bill toEntity (BillEntityResponseDTO billEntityResponseDTO);
    List<Bill> toEntities (List<BillEntityResponseDTO> billEntityResponseDTOs);

    BillTransactionDTO toTransactionDTO (Bill bill);
    List<BillTransactionDTO> toTransactionDTOs (List<Bill> bills);
    Bill toTransactionEntity (BillTransactionDTO billTransactionDTO);
    List<Bill> toTransactionEntities (List<BillTransactionDTO> billTransactionDTOs);
}
