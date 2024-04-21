package com.muzhaqi.InventoryApp.dto.billDTO;

import lombok.Data;

import java.util.List;

@Data
public class BillCreateDTO {
    private String type;
    private List<BillTransactionDTO> transactions;
}
