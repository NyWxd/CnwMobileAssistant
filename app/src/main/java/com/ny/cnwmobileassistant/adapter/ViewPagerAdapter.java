package com.ny.cnwmobileassistant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ny.cnwmobileassistant.bean.FragmentInfo;
import com.ny.cnwmobileassistant.ui.fragment.CategoryFragment;
import com.ny.cnwmobileassistant.ui.fragment.GamesFragment;
import com.ny.cnwmobileassistant.ui.fragment.HomeFragment;
import com.ny.cnwmobileassistant.ui.fragment.RankingFragment;
import com.ny.cnwmobileassistant.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author NiuYuan
 * @Date 2019/6/20
 * @Description
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    private List<FragmentInfo> mFragments = new ArrayList<>(4);

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments(){
        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new FragmentInfo("排行",RankingFragment.class));
        mFragments.add(new FragmentInfo("分类",CategoryFragment.class));
        mFragments.add(new FragmentInfo("游戏",GamesFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
