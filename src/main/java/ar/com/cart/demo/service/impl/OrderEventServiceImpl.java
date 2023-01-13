package ar.com.cart.demo.service.impl;

import ar.com.cart.demo.dto.OrderDto;
import ar.com.cart.demo.event.Event;
import ar.com.cart.demo.event.EventType;
import ar.com.cart.demo.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderEventServiceImpl {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.order.name:orders}")
    private String topicOrder;

    public void publish(OrderDto dto) {

        OrderCreatedEvent created = new OrderCreatedEvent();
        System.out.println(dto);
        created.setData(dto);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicOrder, created);
    }



}