package com.muzhaqi.InventoryApp.dto.billDTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BillEntityResponseDTO {
    private Date date;
    private String type;
    private List<BillTransactionDTO> transactions;
    private Double totalValue;
}
