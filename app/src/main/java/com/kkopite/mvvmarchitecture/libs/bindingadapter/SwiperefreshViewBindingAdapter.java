package com.kkopite.mvvmarchitecture.libs.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import com.kkopite.mvvmarchitecture.libs.command.ReplyCommand;

/**
 * Created by kkopite on 2018/10/29.
 */

public class SwiperefreshViewBindingAdapter {

    @BindingAdapter({"onRefreshCommand"})
    public static void onRefreshCommand(SwipeRefreshLayout swipeRefreshLayout, final ReplyCommand onRefreshCommand) {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (onRefreshCommand != null) {
                onRefreshCommand.execute();
            }
        });
    }
}
