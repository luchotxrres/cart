package ar.com.cart.demo.service;

import ar.com.cart.demo.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {

    OrderDto createOrder(OrderDto dto);

}
