package com.example.examen1;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.examen1.api.APIClient;
import com.example.examen1.api.APIInterface;
import com.example.examen1.dto.Product;
import com.example.examen1.dto.ProductList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private TextView nombreTextView;
    private TextView descriptionTextView;
    private TextView precioTextView;
    private TextView discountTextView;
    private TextView ratingTextView;
    private TextView stockTextView;
    private TextView categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nombreTextView = findViewById(R.id.nombre);
        descriptionTextView = findViewById(R.id.description);
        precioTextView = findViewById(R.id.precio);
        discountTextView = findViewById(R.id.discount);
        ratingTextView = findViewById(R.id.rating);
        stockTextView = findViewById(R.id.stock);
        categoria = findViewById(R.id.categoria);


        Intent intent = getIntent();
        int productId = intent.getIntExtra("productId", -1);
        APIInterface api = APIClient.getClient().create(APIInterface.class);

        api.find(productId).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Log.w("onResponse", response.body().toString());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.w("onFailure", t.getLocalizedMessage());
            }
        });
    }
}