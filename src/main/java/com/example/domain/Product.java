package com.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer priceTaxIncluded; // 税込み価格
    private Integer priceTaxExcluded; // 税抜き価格
}
