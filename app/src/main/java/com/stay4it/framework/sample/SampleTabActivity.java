package com.stay4it.framework.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.stay4it.framework.R;
import com.stay4it.framework.core.BaseActivity;
import com.stay4it.framework.core.ITabFragment;
import com.stay4it.framework.widgets.tab.TabLayout;

import java.util.ArrayList;

/**
 * Created by Stay on 19/3/16.
 * Powered by www.stay4it.com
 */
public class SampleTabActivity extends BaseActivity implements TabLayout.OnTabClickListener {

    private TabLayout mTabLayout;
    private ITabFragment fragment;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_sample_tab, R.string.title_framework_main, MODE_HOME);
    }


    @Override
    protected void setUpView() {
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        ArrayList<TabLayout.Tab> tabs = new ArrayList<>();
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_msg, R.string.home_tab_news, R.menu.menu_home, SampleListFragment.class));
//        tabs.add(new TabView.Tab(R.mipmap.ic_launcher, R.string.home_tab_read));
//        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_contact, R.string.home_tab_audio, R.menu.menu_home, SampleListFragment.class));
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_moments, R.string.home_tab_topic, R.menu.menu_home, SampleSectionListFragment.class));
//        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_profile, R.string.home_tab_profile, R.menu.menu_home, SampleSectionListFragment.class));
        mTabLayout.setUpData(tabs, this);
        mTabLayout.setCurrentTab(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onTabClick(TabLayout.Tab tab) {
        try {
            setUpTitle(tab.labelResId);
            setUpMenu(tab.menuResId);


            ITabFragment tmpFragment = (ITabFragment) getSupportFragmentManager().findFragmentByTag(tab.targetFragmentClz.getSimpleName());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (tmpFragment == null) {
                tmpFragment = tab.targetFragmentClz.newInstance();
                transaction.add(R.id.mFragmentContainerLayout, tmpFragment.getFragment(), tab.targetFragmentClz.getSimpleName());
                if (fragment != null) {
                    transaction.hide(fragment.getFragment());
                }
                transaction.commit();
            } else {
                transaction.show(tmpFragment.getFragment());
                if (fragment != null) {
                    transaction.hide(fragment.getFragment());
                }
                transaction.commit();
            }
            fragment = tmpFragment;

//            fragment = tab.targetFragmentClz.newInstance();
//            getSupportFragmentManager().beginTransaction().
//                    replace(R.id.mFragmentContainerLayout, fragment.getFragment())
//                    .commitAllowingStateLoss();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        fragment.onMenuItemClick();

        return super.onMenuItemClick(item);
    }
}
