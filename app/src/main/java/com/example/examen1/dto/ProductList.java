package com.example.examen1.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    @SerializedName("products")
    public List<Product> products = new ArrayList<>();

    public ProductList(List<Product> products) {
        this.products = products;
    }
}
