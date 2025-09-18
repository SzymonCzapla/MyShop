package com.szymon.myshop;

import com.szymon.myshop.model.Item;
import com.szymon.myshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Autowired
    public DbInit(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("I5-13600k", new BigDecimal("1500.00"), "https://image.ceneostatic.pl/data/products/140261844/4da061d6-b473-4282-a6de-d44396769619_i-intel-core-i5-13600k-3-5ghz-box-bx8071513600k.jpg"),
                new Item("I7-13700k", new BigDecimal("1800.00"), "https://coppotech.com/cdn/shop/files/86K3S5V9j0i0e1y6O6F4q2x7W9T1J5T1.webp?v=1701242155"),
                new Item("I9-13900k", new BigDecimal("2700.00"), "https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2022/9/pr_2022_9_27_12_7_41_412_01.jpg")
        ));
    }
}
