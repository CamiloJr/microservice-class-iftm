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
@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private Integer quantity;
    private Date date;
    private Double totalPrice;
    private Product product;
    private User user;

    public void SumTotalPrice() {
        if(product != null)
            this.totalPrice = this.quantity * product.getPrice();
    }
}