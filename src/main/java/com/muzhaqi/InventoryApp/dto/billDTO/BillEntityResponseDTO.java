package com.muzhaqi.InventoryApp.dto.billDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muzhaqi.InventoryApp.dto.categoryDTO.CategoryEntityResponseDTO;
import com.muzhaqi.InventoryApp.dto.transactionDTO.TransactionEntityResponseDTO;
import com.muzhaqi.InventoryApp.entity.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BillEntityResponseDTO {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "CET")
    private Date date;
    private String type;
    private List<TransactionEntityResponseDTO> transactions;
    private CategoryEntityResponseDTO category;
    private Double totalValue;
}
