package ar.com.cart.demo.service.impl;

import ar.com.cart.demo.dto.CartDto;
import ar.com.cart.demo.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartServiceImpl implements CartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    public CartDto createOrder(CartDto dto) {
        LOGGER.info("Se envía la orden de pedido, dto: {}", dto);
        return null;
    }
}