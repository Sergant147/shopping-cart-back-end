package com.example.demo.service.cart;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart intializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
