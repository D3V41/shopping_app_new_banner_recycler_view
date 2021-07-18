package com.example.progaurd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progaurd.R;
import com.example.progaurd.model.HorizontalProductsScrollModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HorizontalProductsScrollAdapter extends RecyclerView.Adapter<HorizontalProductsScrollAdapter.ViewHolder> {

    private List<HorizontalProductsScrollModel> horizontalProductsScrollModelList;

    public HorizontalProductsScrollAdapter(List<HorizontalProductsScrollModel> horizontalProductsScrollModelList) {
        this.horizontalProductsScrollModelList = horizontalProductsScrollModelList;
    }

    @NonNull
    @NotNull
    @Override
    public HorizontalProductsScrollAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HorizontalProductsScrollAdapter.ViewHolder holder, int position) {
        int resource = horizontalProductsScrollModelList.get(position).getProductImage();
        String title = horizontalProductsScrollModelList.get(position).getProductTitle();
        String description = horizontalProductsScrollModelList.get(position).getProductDescription();
        String prize = horizontalProductsScrollModelList.get(position).getProductPrize();

        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductDescription(description);
        holder.setProductPrize(prize);
    }

    @Override
    public int getItemCount() {
        if(horizontalProductsScrollModelList.size()>8){
            return 8;
        }else {
            return horizontalProductsScrollModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrize;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrize = itemView.findViewById(R.id.h_s_product_prize);
        }

        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String description){
            productDescription.setText(description);
        }
        private void setProductPrize(String prize){
            productPrize.setText(prize);
        }
    }
}
