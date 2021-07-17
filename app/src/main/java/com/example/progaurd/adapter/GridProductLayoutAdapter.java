package com.example.progaurd.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.progaurd.R;
import com.example.progaurd.model.HorizontalProductsScrollModel;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProductsScrollModel> horizontalProductsScrollModelList;

    public GridProductLayoutAdapter(List<HorizontalProductsScrollModel> horizontalProductsScrollModelList) {
        this.horizontalProductsScrollModelList = horizontalProductsScrollModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDescription = view.findViewById(R.id.h_s_product_description);
            TextView productPrize = view.findViewById(R.id.h_s_product_prize);

            productImage.setImageResource(horizontalProductsScrollModelList.get(position).getProductImage());
            productTitle.setText(horizontalProductsScrollModelList.get(position).getProductTitle());
            productDescription.setText(horizontalProductsScrollModelList.get(position).getProductDescription());
            productPrize.setText(horizontalProductsScrollModelList.get(position).getProductPrize());
        }
        else {
            view = convertView;
        }
        return view;
    }
}
