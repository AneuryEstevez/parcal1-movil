package com.example.examen1;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.examen1.dto.Product;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductsRepository repository;
    private MutableLiveData<List<Product>> productsLiveData;
    public ProductViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new ProductsRepository(application);
        productsLiveData = repository.getProductsLiveData();
    }

    public MutableLiveData<List<Product>> getProductsLiveData() {
        return productsLiveData;
    }
}
