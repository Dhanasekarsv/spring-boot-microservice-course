package com.dvlabs.bookstore.orders.web.controllers;

import com.dvlabs.bookstore.orders.web.controllers.RabbitMQDemoController.Mypayload;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
class RabbitMQListener {
    @RabbitListener(queues = "${orders.new-orders-queue}")
    public void handleneworder(Mypayload payload) {
        System.out.println("New order: " + payload.content());
    }

    @RabbitListener(queues = "${orders.delivered-orders-queue}")
    public void handledeliveredorder(Mypayload payload) {
        System.out.println("Delivered order: " + payload.content());
    }
}
