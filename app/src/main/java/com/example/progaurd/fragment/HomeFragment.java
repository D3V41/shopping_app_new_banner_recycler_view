package com.example.progaurd.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.progaurd.R;
import com.example.progaurd.adapter.CategoryAdapter;
import com.example.progaurd.adapter.GridProductLayoutAdapter;
import com.example.progaurd.adapter.HomePageAdapter;
import com.example.progaurd.adapter.HorizontalProductsScrollAdapter;
import com.example.progaurd.model.CategoryModel;
import com.example.progaurd.model.HomePageModel;
import com.example.progaurd.model.HorizontalProductsScrollModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    /////// banner slider
    private ImageSlider bannerSlider;
    private List<SlideModel> sliderModelList;
    private int currentPage = 2;

    private Timer timer;
    final private long DELAY_TIME = 2000;
    final private long PERIOD_TIME = 1000;
    ////// banner slider

    ////////// strip ad
    private ImageView stripAdImage;
    ////////// strip ad

    ////////// horizontal product layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllButton;
    private RecyclerView horizontalRecyclerView;
    ////////// horizontal product layout


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Phone"));
        categoryModelList.add(new CategoryModel("link","TV"));
        categoryModelList.add(new CategoryModel("link","Headphone"));
        categoryModelList.add(new CategoryModel("link","Usb"));
        categoryModelList.add(new CategoryModel("link","Mango"));
        categoryModelList.add(new CategoryModel("link","Cake"));
        categoryModelList.add(new CategoryModel("link","Puff"));
        categoryModelList.add(new CategoryModel("link","Samosa"));
        categoryModelList.add(new CategoryModel("link","Cable"));

        categoryAdapter = new CategoryAdapter(categoryModelList);

        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        //// banner slider
        bannerSlider = view.findViewById(R.id.banner_slider);
        sliderModelList = new ArrayList<SlideModel>();

        sliderModelList.add(new SlideModel(R.drawable.banner, ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        sliderModelList.add(new SlideModel(R.drawable.banner,ScaleTypes.CENTER_CROP));
        //// banner slider

        ////////// strip ad
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdImage.setImageResource(R.drawable.stripad);
        ////////// strip ad

        ////////// horizontal product layout
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllButton = view.findViewById(R.id.horizontal_scroll_view_all_layout_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductsScrollModel> horizontalProductsScrollModelList = new ArrayList<HorizontalProductsScrollModel>();
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.dummyphone,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_headphone,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_home,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_grid,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_order,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_gift,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.ic_person,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));
        horizontalProductsScrollModelList.add(new HorizontalProductsScrollModel(R.drawable.forgot_password,"Oppo F9 Pro","SD 756 Processor","Rs.5999/-"));

        HorizontalProductsScrollAdapter horizontalProductsScrollAdapter = new HorizontalProductsScrollAdapter(horizontalProductsScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductsScrollAdapter);
        horizontalProductsScrollAdapter.notifyDataSetChanged();
        ////////// horizontal product layout

        ////////// grid product layout
        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllButton = view.findViewById(R.id.grid_product_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_grid_view);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductsScrollModelList));
        ////////// grid product layout

        ///////////////////////

        RecyclerView testing = view.findViewById(R.id.testing);

        List<HomePageModel> homePageModelList = new ArrayList<HomePageModel>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the DAY!",horizontalProductsScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad));
        homePageModelList.add(new HomePageModel(3,"Trending",horizontalProductsScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Offers!",horizontalProductsScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.stripad));
        homePageModelList.add(new HomePageModel(3,"Best for YOU!",horizontalProductsScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Big billion day!",horizontalProductsScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Today's offer",horizontalProductsScrollModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        LinearLayoutManager testingLinearLayoutManager = new LinearLayoutManager(getContext());
        testingLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLinearLayoutManager);
        testing.getLayoutManager().setMeasurementCacheEnabled(false);

        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ///////////////////////

        return view;
    }

}