package com.weizi.wxmanager.Activity;

import com.weizi.wxmanager.ImageLoader.GlideImageLoader;
import com.weizi.wxmanager.R;
import com.weizi.wxmanager.base.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity   extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        images.add("https://img.tukuppt.com//ad_preview/00/03/30/5c98a556e3a89.jpg!/fw/980");
        images.add("https://img.tukuppt.com//ad_preview/00/03/67/5c98ae2478f79.jpg!/fw/780");
        images.add("https://img.tukuppt.com/bg_grid/00/03/52/NArgrNOIux.jpg!/fh/350");
        titles.add("a");
        titles.add("b");
        titles.add("b");
        titles.add("c");
        initBanner(images,titles);
    }

    @Override
    public void requestData() {

    }

    public void initBanner(List<String> images,List<String> titles){
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}
