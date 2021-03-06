package com.stay4it.framework.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;
import com.stay4it.framework.utils.L;
import com.stay4it.framework.widgets.LoopViewPager;

/**
 * Created by Stay on 10/4/16.
 * Powered by www.stay4it.com
 */
public class SampleLoopPageActivity extends BaseActivity {
    private LoopViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_loop_page);
    }

    @Override
    protected void setUpView() {
        viewPager = (LoopViewPager) findViewById(R.id.viewPager);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            L.e("getItem:" + position);
            position = (5 + position % 5) % 5;
            return SampleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 5;
        }

    }
}
