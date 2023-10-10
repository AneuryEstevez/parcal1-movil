package com.example.examen1;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen1.api.APIClient;
import com.example.examen1.api.APIInterface;
import com.example.examen1.databinding.ActivityMainBinding;
import com.example.examen1.dto.Product;
import com.example.examen1.dto.ProductList;
import com.example.examen1.dto.UserList;
import kotlinx.coroutines.scheduling.Task;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = binding.RecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        RetrofitAdapter adapter = new RetrofitAdapter(new RetrofitAdapter.ProductDiff());
        recyclerView.setAdapter(adapter);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productViewModel.getProductsLiveData().observe(this, products -> {
            adapter.submitList(products);
        });

        APIInterface api = APIClient.getClient().create(APIInterface.class);

        api.findAll().enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                Log.w("onResponse", response.body().products.toString());
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.w("onFailure", t.getLocalizedMessage());
            }
        });
    }

    ActivityResultLauncher<Intent> detailsActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
//                    Task task = new Task(data.getStringExtra(NewTaskActivity.EXTRA_REPLY), false);
//                    taskViewModel.insert(task);
                } else {
                    Toast.makeText(getApplicationContext(), "No guardado", Toast.LENGTH_LONG).show();
                }
            });
}