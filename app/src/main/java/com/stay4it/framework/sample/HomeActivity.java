package com.stay4it.framework.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stay4it.framework.R;
import com.stay4it.framework.constants.ConstantValues;
import com.stay4it.framework.core.BaseListActivity;
import com.stay4it.framework.model.Module;
import com.stay4it.framework.widgets.pull.BaseViewHolder;

import java.util.ArrayList;

/**
 * Created by Stay on 2/2/16.
 * Powered by www.stay4it.com
 */
public class HomeActivity extends BaseListActivity<Module> {

    @Override
    protected void setUpTitle(int titleResId) {
        super.setUpTitle(R.string.title_framework_main);
    }

    @Override
    protected void setUpMenu(int menuId) {
        super.setUpMenu(R.menu.menu_home);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        super.setUpData(savedInstanceState);
        recycler.enablePullToRefresh(false);
        recycler.setRefreshing();
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onRefresh(int action) {
        mDataList = new ArrayList<>();
        mDataList.add(new Module("RecyclerView基于BaseListActivity\n支持下拉刷新,加载更多", SampleListActivity.class));
        mDataList.add(new Module("RecyclerView基于BaseListFragment\n支持下拉刷新,加载更多", SampleListActivity1.class));
        mDataList.add(new Module("RecyclerView基于BaseSectionListActivity\n支持分组,下拉刷新,加载更多", SampleSectionListActivity.class));
        mDataList.add(new Module("RecyclerView基于BaseSectionListFragment\n支持分组,下拉刷新,加载更多", SampleSectionListActivity1.class));
        mDataList.add(new Module("Tab", SampleTabActivity.class));
        mDataList.add(new Module("ViewPager", SamplePageActivity.class));
        mDataList.add(new Module("LoopViewPager", SampleLoopPageActivity.class));
        mDataList.add(new Module("Banner", BannerActivity.class));
        recycler.onRefreshCompleted();
    }

    private class ViewHolder extends BaseViewHolder {
        private final TextView mHomeItemModuleLabel;

        public ViewHolder(View view) {
            super(view);
            mHomeItemModuleLabel = (TextView) view.findViewById(R.id.mHomeItemModuleLabel);
        }

        @Override
        public void onBindViewHolder(int position) {
            mHomeItemModuleLabel.setText(mDataList.get(position).moduleName);
        }

        @Override
        public void onItemClick(View view, int position) {
            startActivity(new Intent(HomeActivity.this, mDataList.get(position).moduleTargetClass));
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stay4it.com/course/7"));
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int action = intent.getIntExtra(ConstantValues.KEY_HOME_ACTION, ConstantValues.ACTION_BACK_TO_HOME);
        switch (action) {
            case ConstantValues.ACTION_KICK_OUT:
                break;
            case ConstantValues.ACTION_LOGOUT:
                break;
            case ConstantValues.ACTION_RESTART_APP:
                protectApp();
                break;
            case ConstantValues.ACTION_BACK_TO_HOME:
                break;
        }
    }

    @Override
    protected void protectApp() {
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }
}
