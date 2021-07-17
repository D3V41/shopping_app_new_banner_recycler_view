package com.example.progaurd.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.progaurd.R;
import com.example.progaurd.adapter.CategoryAdapter;
import com.example.progaurd.adapter.GridProductLayoutAdapter;
import com.example.progaurd.adapter.HorizontalProductsScrollAdapter;
import com.example.progaurd.adapter.SliderAdapter;
import com.example.progaurd.model.CategoryModel;
import com.example.progaurd.model.HorizontalProductsScrollModel;
import com.example.progaurd.model.SliderModel;

import org.jetbrains.annotations.NotNull;

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
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;

    private Timer timer;
    final private long DELAY_TIME = 3000;
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
        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.ic_home,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.forgot_password,"#5C4A8A"));

        sliderModelList.add(new SliderModel(R.drawable.banner,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.button_selected,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.button_not_selected,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.edittext_background,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.google_btn,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.ic_home,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.forgot_password,"#5C4A8A"));

        sliderModelList.add(new SliderModel(R.drawable.banner,"#5C4A8A"));
        sliderModelList.add(new SliderModel(R.drawable.button_selected,"#5C4A8A"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    pageLopper();
                }
            }

        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLopper();
                stopBannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
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
        LinearLayoutManager testingLinearLayoutManager = new LinearLayoutManager(getContext());
        testingLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        testing.setLayoutManager(testingLinearLayoutManager);
        ///////////////////////

        return view;
    }

    //////// banner slider
    private void pageLopper(){
        if(currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1){
            currentPage = sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

    }

    private void startBannerSlideShow(){
        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 2;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }
    //////// banner slider
}