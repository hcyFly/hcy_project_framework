package com.stay4it.framework.sample;

import android.os.Bundle;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;
import com.stay4it.framework.utils.L;

/**
 * Created by Stay on 2/2/16.
 * Powered by www.stay4it.com
 */
public class SampleListActivity1 extends BaseActivity {

    private SampleListFragment mSampleListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_list_1, R.string.title_recycler_fragment);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            L.e("onCreate(savedInstanceState);" + savedInstanceState);
            mSampleListFragment = (SampleListFragment) getSupportFragmentManager().findFragmentByTag("SampleListFragment");
            L.e(mSampleListFragment.toString());
        } else {
            mSampleListFragment = new SampleListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.mSampleListFragmentLayout, mSampleListFragment, "SampleListFragment").commit();
        }

    }
}
