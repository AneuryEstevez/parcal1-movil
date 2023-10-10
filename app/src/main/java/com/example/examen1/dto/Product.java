package com.example.examen1.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("price")
    public Double price;
    @SerializedName("discountPercentage")
    public Double discountPercentage;

    @SerializedName("rating")
    public Double rating;

    @SerializedName("stock")
    public int stock;

    @SerializedName("brand")
    public String brand;

    @SerializedName("category")
    public String category;

    @SerializedName("thumbnail")
    public String thumbnail;

    @SerializedName("images")
    public List<String> images;

    public Product(Integer id, String title, String description, Double price, Double discountPercentage, Double rating, int stock, String brand, String category, String thumbnail, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", rating=" + rating +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", images=" + images +
                '}';
    }
}
