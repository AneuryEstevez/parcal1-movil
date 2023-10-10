package com.example.examen1;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examen1.dto.Product;
import org.jetbrains.annotations.NotNull;

public class RetrofitAdapter extends ListAdapter<Product, RetrofitAdapter.ProductViewHolder> {
    protected RetrofitAdapter(@NonNull @NotNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductViewHolder holder, int position) {
        Product product = getItem(position);
        holder.bind(product.getTitle(), product.getDescription(), product.getId().toString());

        // Set click listener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle item click, e.g., start a new activity
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("productId", product.getId()); // Pass data to the new activity if needed
                view.getContext().startActivity(intent);
            }
        });
    }

    public static class ProductDiff extends DiffUtil.ItemCallback<Product> {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView titulo;
        private final TextView descripcion;
        private final TextView id;

        private ProductViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            descripcion = itemView.findViewById(R.id.descripcion);
            id = itemView.findViewById(R.id.id_textview);
        }

        public void bind(String text, String desc, String id_text) {
            titulo.setText(text);
            descripcion.setText(desc);
            id.setText(id_text);
        }

        static ProductViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ProductViewHolder(view);
        }

    }

}