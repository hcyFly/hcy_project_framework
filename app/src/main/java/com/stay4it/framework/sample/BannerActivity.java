package com.stay4it.framework.sample;

import android.os.Bundle;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;
import com.stay4it.framework.widgets.banner.BannerView;

import java.util.ArrayList;

/**
 * Created by Stay on 10/4/16.
 * Powered by www.stay4it.com
 */
public class BannerActivity extends BaseActivity implements BannerView.OnBannerItemClickListener {

    private BannerView mBannerView;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_banner);
    }

    @Override
    protected void setUpView() {
        mBannerView = (BannerView) findViewById(R.id.mBannerView);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        ArrayList<BannerView.Banner> banners = new ArrayList<>();
        banners.add(new BannerView.Banner(R.drawable.ic_tab_contact));
        banners.add(new BannerView.Banner(R.drawable.ic_tab_msg));
        banners.add(new BannerView.Banner(R.drawable.ic_tab_moments));
        banners.add(new BannerView.Banner(R.drawable.ic_tab_profile));
        mBannerView.setUpData(banners, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBannerView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBannerView.onStop();
    }

    @Override
    public void onBannerClick(int index, BannerView.Banner banner) {

    }
}
