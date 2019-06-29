package com.ny.cnwmobileassistant.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ny.cnwmobileassistant.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @Author NiuYuan
 * @Date 2019/6/20
 * @Description
 */

public class RecommendFragment extends Fragment {
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);

        doSthInBackground();
        return view;
    }

    private void doSthInBackground() {
        MyThread mt = new MyThread();

        mt.start();
        try {
            mt.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mt.run();

        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread = new Thread(myRunnableThread);
        thread.start();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            //在子线程要做的事情
        }
    }

    class MyRunnableThread implements Runnable{

        @Override
        public void run() {

        }
    }

}
