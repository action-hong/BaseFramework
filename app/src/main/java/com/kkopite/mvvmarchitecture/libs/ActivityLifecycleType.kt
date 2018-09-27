package com.kkopite.mvvmarchitecture.libs

import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable

/**
 * Created by kkopite on 2018/9/27.
 */
public interface ActivityLifecycleType {

    fun lifecycle(): Observable<ActivityEvent>
}