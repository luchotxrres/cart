package ar.com.cart.demo.controller;

import ar.com.cart.demo.dto.CartDto;
import ar.com.cart.demo.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


import javax.validation.constraints.Null;

@RestController
@Tag(name = "CartController", description = "Controller para gestión del carrito")
@RequestMapping(CartController.URI)
public class CartController {
    public static final String URI = "/ms-cart/v1";

    public static final String order = "/order";
    public final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Envia un Sms a un phoneNumber dado", description = "Envia un Sms a un phoneNumber dado", tags = {
            "SmsController" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),

            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),

            @ApiResponse(responseCode = "500", description = "Unexpected Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})

    @PostMapping(path = order)
    public CartDto createOrder(@RequestBody CartDto requestDto){
        return cartService.createOrder(requestDto);
    }

}
