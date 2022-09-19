package com.store.purchaseorder.message;

import com.store.purchaseorder.entities.Action;
import com.store.purchaseorder.entities.Order;
import com.store.purchaseorder.entities.PurchaseOrderLog;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderSendMessageLog {

    @Value("${store.rabbitmq.exchange}")
    String exchange;

    @Value("${store.rabbitmq.log.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Order order, Action action) {
        PurchaseOrderLog purchaseOrderLog = new PurchaseOrderLog();
        purchaseOrderLog.setAction(action);
        purchaseOrderLog.setOrderId(order.getId());
        purchaseOrderLog.setQuantity(order.getQuantity());
        purchaseOrderLog.setDate(order.getDate());
        purchaseOrderLog.setTotalPrice(order.getTotalPrice());
        purchaseOrderLog.setProductName(order.getProduct().getName());
        purchaseOrderLog.setProductCode(order.getProduct().getCode());
        purchaseOrderLog.setManufacture(order.getProduct().getManufacture());
        purchaseOrderLog.setPrice(order.getProduct().getPrice());
        purchaseOrderLog.setUserName(order.getUser().getName());
        purchaseOrderLog.setCpf(order.getUser().getCpf());

        rabbitTemplate.convertAndSend(exchange, routingKey, purchaseOrderLog);
    }
}
