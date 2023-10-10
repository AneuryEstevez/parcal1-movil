package com.example.examen1;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.examen1.api.APIClient;
import com.example.examen1.api.APIInterface;
import com.example.examen1.dto.Product;
import com.example.examen1.dto.ProductList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ProductsRepository {
    private final APIInterface api;
    private MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();

    public ProductsRepository(Application application) {
        api = APIClient.getClient().create(APIInterface.class);

        api.findAll().enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                productsLiveData.setValue(response.body().products);
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.w("onFailure", t.getMessage());
                call.cancel();
            }
        });
    }

    public MutableLiveData<List<Product>> getProductsLiveData() {
        return productsLiveData;
    }
}
