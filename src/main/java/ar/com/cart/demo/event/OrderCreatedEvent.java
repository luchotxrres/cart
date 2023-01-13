package ar.com.cart.demo.event;

import ar.com.cart.demo.dto.OrderDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCreatedEvent extends Event<OrderDto> {

}