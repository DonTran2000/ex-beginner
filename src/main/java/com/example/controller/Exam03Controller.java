package com.example.controller;

import com.example.domain.Product;
import com.example.form.ProductForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

    @GetMapping("")
    public String index(ProductForm form) {
        return "exam03";
    }

    @PostMapping("/exam03Result")
    public String exam03Result(ProductForm form, Model model) {
        Product product = new Product();

        Integer item1 = Integer.parseInt(form.getItem1());
        Integer item2 = Integer.parseInt(form.getItem2());
        Integer item3 = Integer.parseInt(form.getItem3());

        int priceTaxExcluded = item1 + item2 + item3;

        int priceTaxIncluded = (int) (priceTaxExcluded + priceTaxExcluded * 0.1);

        product.setItem1(item1);
        product.setItem2(item2);
        product.setItem3(item3);
        product.setPriceTaxIncluded(priceTaxIncluded);
        product.setPriceTaxExcluded(priceTaxExcluded);

        model.addAttribute("product", product);
        return "exam03-result";
    }
}
