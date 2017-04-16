package com.stay4it.framework.sample;

import android.os.Bundle;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;

/**
 * Created by Stay on 2/2/16.
 * Powered by www.stay4it.com
 */
public class SampleSectionListActivity1 extends BaseActivity {

    private SampleSectionListFragment mSampleListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_list_1, R.string.title_recycler_section_fragment);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        mSampleListFragment = new SampleSectionListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mSampleListFragmentLayout, mSampleListFragment).commit();
    }
}
