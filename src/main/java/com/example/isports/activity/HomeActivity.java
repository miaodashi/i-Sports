package com.example.isports.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.isports.R;
import com.example.isports.adapter.MyPagerAdapter;
import com.example.isports.entity.TabEntity;
import com.example.isports.fragment.ExploreFragment;
import com.example.isports.fragment.HomeFragment;
import com.example.isports.fragment.MyFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private String[] mTitles = {"首页", "资讯", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselected, R.mipmap.explore_unselected,
            R.mipmap.my_unselected};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.explore_selected,
            R.mipmap.my_selected};
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager=findViewById(R.id.viewPager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ExploreFragment.newInstance());
        mFragments.add(MyFragment.newInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
    }
}