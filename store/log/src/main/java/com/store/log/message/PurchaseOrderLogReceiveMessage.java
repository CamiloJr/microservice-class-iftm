package com.store.log.message;

import com.store.log.entities.PurchaseOrderLog;
import com.store.log.services.PurchaseOrderLogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class PurchaseOrderLogReceiveMessage {

    @Autowired
    private PurchaseOrderLogService purchaseOrderLogService;

    @RabbitListener(queues = {"${store.rabbitmq.purchaseorder.log.queue}"})
    public void receive(@Payload PurchaseOrderLog purchaseOrderLog) {
        System.out.println(purchaseOrderLog.toString());
        purchaseOrderLogService.save(purchaseOrderLog);
    }
}
