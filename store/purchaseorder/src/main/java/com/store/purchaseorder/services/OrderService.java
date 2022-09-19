package com.store.purchaseorder.services;

import com.store.purchaseorder.entities.Action;
import com.store.purchaseorder.entities.Order;
import com.store.purchaseorder.message.PurchaseOrderSendMessageLog;
import com.store.purchaseorder.repositories.OrderRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    PurchaseOrderSendMessageLog purchaseOrderSendMessageLog;

    public Order findById(String id) {
        var order = orderRepository.findById(id).stream().findFirst().orElse(null);
        return order;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        order.SumTotalPrice();
        var newOrder = orderRepository.save(order);
        purchaseOrderSendMessageLog.sendMessage(newOrder, Action.ADD);
        return newOrder;
    }

    public Order update(Order order) {
        if(order != null && !order.getId().isEmpty()) {
            var dbOrder = findById(order.getId());
            if(dbOrder != null)
            {
                order.SumTotalPrice();
                var newOrder = orderRepository.save(order);
                purchaseOrderSendMessageLog.sendMessage(newOrder, Action.UPDATE);
                return newOrder;
            }
        }
        return null;
    }

    public void delete(Order order) {
        if(order != null && !order.getId().isEmpty())
        {
            purchaseOrderSendMessageLog.sendMessage(order, Action.REMOVE);
            orderRepository.delete(order);
        }

    }

    public void delete(@NotNull String id){
        if(!id.isEmpty())
        {
           var order = findById(id);
           if(order != null) {
               purchaseOrderSendMessageLog.sendMessage(order, Action.REMOVE);
               orderRepository.deleteById(id);
           }
        }
    }
}