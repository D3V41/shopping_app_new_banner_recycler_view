package com.example.progaurd.model;

import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER = 0;
    public static final int STRIP_AD_BANNER = 1;
    public static final int HORIZONTAL_PRODUCT_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;

    private int type;

    /////// banner slider
    private List<SliderModel> sliderModelList;
    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    /////// banner slider

    ////////// strip ad
    private int resource;
    public HomePageModel(int type, int resource) {
        this.type = type;
        this.resource = resource;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    ////////// strip ad

    ////////// horizontal product layout && grid product layout
    private String title;
    private List<HorizontalProductsScrollModel> horizontalProductsScrollModelList;
    public HomePageModel(int type, String title, List<HorizontalProductsScrollModel> horizontalProductsScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductsScrollModelList = horizontalProductsScrollModelList;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<HorizontalProductsScrollModel> getHorizontalProductsScrollModelList() {
        return horizontalProductsScrollModelList;
    }
    public void setHorizontalProductsScrollModelList(List<HorizontalProductsScrollModel> horizontalProductsScrollModelList) {
        this.horizontalProductsScrollModelList = horizontalProductsScrollModelList;
    }
    ////////// horizontal product layout && grid product layout



}
