package com.example.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private String item1;
    private String item2;
    private String item3;
    private String priceTaxIncluded; // 税込み価格
    private String priceTaxExcluded; // 税抜き価格
}
