package com.ny.cnwmobileassistant.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ny.cnwmobileassistant.R;
import com.ny.cnwmobileassistant.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.hint_navigation_view)
    NavigationView mHintNavigationView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private View mHeaderView;
    private Context mContext;
    private ActionBarDrawerToggle mDrawerToggle;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        ButterKnife.bind(this);

        initDrawerLayout();
        initTabLayout();
    }

    private void initTabLayout() {
        mPageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initDrawerLayout() {
        mHeaderView = mHintNavigationView.getHeaderView(0);
        mHeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "headerView", Toast.LENGTH_SHORT).show();
            }
        });
        mHintNavigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        mToolBar.inflateMenu(R.menu.toolbar_menu);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        mDrawerToggle.syncState();

        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_app_update:
                    Toast.makeText(mContext, "应用更新", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_message:
                    Toast.makeText(mContext, "消息", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_setting:
                    Toast.makeText(mContext, "设置", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };
}
