package ar.com.cart.demo.service.impl;

import ar.com.cart.demo.dto.OrderDto;
import ar.com.cart.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderEventServiceImpl orderEventService;

    public OrderServiceImpl(OrderEventServiceImpl orderEventService) {
        super();
        this.orderEventService = orderEventService;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        LOGGER.info("Se envía la orden de pedido, dto: {}", dto);
        this.orderEventService.publish(dto);
        return dto;
    }
}