package com.szymon.myshop.controller;

import com.szymon.myshop.Cart;
import com.szymon.myshop.ItemOperation;
import com.szymon.myshop.model.Item;
import com.szymon.myshop.repository.ItemRepository;
import com.szymon.myshop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final CartService cartService;

    @Autowired
    public HomeController(CartService cartService){
        this.cartService = cartService;
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model){
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items", cartService.getAllItems());
        return "redirect:/";
    }
}
