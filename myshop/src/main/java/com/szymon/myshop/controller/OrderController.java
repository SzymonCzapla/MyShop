package com.szymon.myshop.controller;

import com.szymon.myshop.ItemOperation;
import com.szymon.myshop.dto.OrderDto;
import com.szymon.myshop.service.CartService;
import com.szymon.myshop.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public OrderController(CartService cartService, OrderService orderService){

        this.cartService = cartService;
        this.orderService = orderService;
    }
    @GetMapping("/cart")
    public String showCart(){
        return "cartView";
    }
    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable("itemId") Long itemId){
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        return "redirect:/order/cart";
    }
    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable("itemId") Long itemId){
        cartService.itemOperation(itemId, ItemOperation.DECREASE);
        return "redirect:/order/cart";
    }
    @GetMapping("/remove/{itemId}")
    public String removeItemsFromCart(@PathVariable("itemId") Long itemId){
        cartService.itemOperation(itemId, ItemOperation.REMOVE);
        return "redirect:/order/cart";
    }
    @GetMapping("/summary")
    public String showSummary(){
        return "summary";
    }
    @PostMapping("/saveorder")
    public String saveOrder(OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return "redirect:/";
    }
}
