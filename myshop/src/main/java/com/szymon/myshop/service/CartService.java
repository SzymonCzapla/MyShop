package com.szymon.myshop.service;

import com.szymon.myshop.Cart;
import com.szymon.myshop.ItemOperation;
import com.szymon.myshop.model.Item;
import com.szymon.myshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final ItemRepository itemRepository;
    private final Cart cart;

    @Autowired
    public CartService(ItemRepository itemRepository, Cart cart){
        this.itemRepository=itemRepository;
        this.cart = cart;
    }
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
    public void itemOperation(Long itemId, ItemOperation itemOperation){
        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()){
            Item item = oItem.get();
            switch (itemOperation){
                case INCREASE -> cart.addItem(item);
                case DECREASE -> cart.decreaseItem(item);
                case REMOVE -> cart.removeAllItems(item);
                default -> throw new IllegalArgumentException();
            }
        }
    }
}
