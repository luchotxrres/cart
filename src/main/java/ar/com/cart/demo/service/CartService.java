package ar.com.cart.demo.service;

import ar.com.cart.demo.dto.CartDto;

public interface CartService {

    CartDto createOrder(CartDto dto);

}
