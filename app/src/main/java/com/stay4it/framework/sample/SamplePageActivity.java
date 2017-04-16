package com.stay4it.framework.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;
import com.stay4it.framework.utils.L;

/**
 * Created by Stay on 10/4/16.
 * Powered by www.stay4it.com
 */
public class SamplePageActivity extends BaseActivity {
    private ViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_page);
    }

    @Override
    protected void setUpView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            L.e("getItem:" + position);
            return SampleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
