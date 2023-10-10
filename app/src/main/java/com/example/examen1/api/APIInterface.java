package com.example.examen1.api;

import com.example.examen1.dto.Product;
import com.example.examen1.dto.ProductList;
import com.example.examen1.dto.UserList;
import com.example.examen1.dto.UserSingle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface APIInterface {

    @GET("products")
    Call<ProductList> findAll();

    @GET("products/{id}")
    Call<Product> find(@Path("id") int id);
}
