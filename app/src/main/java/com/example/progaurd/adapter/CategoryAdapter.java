package com.example.progaurd.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progaurd.R;
import com.example.progaurd.model.CategoryModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryIcon;
        private TextView categoryName;

        public ViewHolder(View view){
            super(view);
            categoryIcon = view.findViewById(R.id.category_icon);
            categoryName = view.findViewById(R.id.category_name);
        }

        private void setCategoryIcon(){

        }
        private void setCategoryName(String name){
            categoryName.setText(name);
        }
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        String icon = categoryModelList.get(position).getCategoryIcon();
        String name = categoryModelList.get(position).getCategoryName();
        holder.setCategoryName(name);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }


}
