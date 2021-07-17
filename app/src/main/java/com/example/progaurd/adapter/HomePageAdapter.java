package com.example.progaurd.adapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.progaurd.R;
import com.example.progaurd.model.HomePageModel;
import com.example.progaurd.model.SliderModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;
            default:
                return -1;
        }
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        switch (viewType){
            case HomePageModel.BANNER_SLIDER:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_ad_layout,parent,false);
                return new BannerSliderViewHolder(view);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderViewPager;
        private int currentPage = 2;

        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 1000;

        public BannerSliderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_view_pager);

        }
        private void setBannerSliderViewPager(List<SliderModel> sliderModelList){
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
                        pageLopper(sliderModelList);
                    }
                }

            };
            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startBannerSlideShow(sliderModelList);

            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLopper(sliderModelList);
                    stopBannerSlideShow();
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        startBannerSlideShow(sliderModelList);
                    }
                    return false;
                }
            });
        }
        private void pageLopper(List<SliderModel> sliderModelList){
            if(currentPage == sliderModelList.size()-2){
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }
            if(currentPage == 1){
                currentPage = sliderModelList.size()-3;
                bannerSliderViewPager.setCurrentItem(currentPage,false);
            }

        }
        private void startBannerSlideShow(List<SliderModel> sliderModelList){
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
    }
}
