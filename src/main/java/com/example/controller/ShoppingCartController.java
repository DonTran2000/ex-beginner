package com.example.controller;

import com.example.domain.Item;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/shop")
public class ShoppingCartController {

    @Autowired
    private ServletContext application;

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String index(Model model) {
        List<Item> itemList = (List<Item>) application.getAttribute("itemList");
        if (itemList == null) {
            itemList = new LinkedList<>();

            Item item1 = new Item();
            item1.setName("手帳ノート");
            item1.setPrice(1000);

            Item item2 = new Item();
            item2.setName("文房具セット");
            item2.setPrice(1500);

            Item item3 = new Item();
            item3.setName("ファイル");
            item3.setPrice(2000);

            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);

            application.setAttribute("itemList", itemList);
        }

        List<Item> cartList = (List<Item>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cartList", cartList);
        }

        Map<String, Map<String, Object>> groupedCart = new LinkedHashMap<>();
        int totalPrice = 0;

        for (Item item : cartList) {
            totalPrice += item.getPrice();

            if (!groupedCart.containsKey(item.getName())) {
                Map<String, Object> details = new HashMap<>();
                details.put("price", item.getPrice());
                details.put("quantity", 1);
                groupedCart.put(item.getName(), details);
            } else {
                Map<String, Object> details = groupedCart.get(item.getName());
                int currentQty = (int) details.get("quantity");
                details.put("quantity", currentQty + 1);
            }
        }

        model.addAttribute("groupedCart", groupedCart);
        model.addAttribute("totalPrice", totalPrice);

        return "item-and-cart";
    }

    @PostMapping("/inCart")
    public String inCart(int index) {
        List<Item> itemList = (List<Item>) application.getAttribute("itemList");

        if (itemList != null) {
            Item selectedItem = itemList.get(index);

            List<Item> cartList = (List<Item>) session.getAttribute("cartList");
            if (cartList == null) {
                cartList = new ArrayList<>();
            }
            cartList.add(selectedItem);
        }

        return "redirect:/shop";
    }

    @PostMapping("/delete")
    public String delete(String itemId) {
        int index = Integer.parseInt(itemId);

        List<Item> cartList = (List<Item>) session.getAttribute("cartList");

        if (cartList != null) {
            cartList.remove(index);
        }

        return "redirect:/shop";
    }
}