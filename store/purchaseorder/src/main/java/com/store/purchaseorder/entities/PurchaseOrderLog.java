package com.store.purchaseorder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderLog {
    private Action action = Action.NONE;
    private String orderId;
    private Integer quantity;
    private Date date;
    private Double totalPrice;
    private String productName;
    private Integer productCode;
    private String manufacture;
    private Double price;
    private String userName;
    private String cpf;
}
