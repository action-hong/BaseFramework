package com.kkopite.mvvmarchitecture.libs

import android.os.Parcelable
import com.google.auto.value.AutoValue
import com.google.gson.Gson
import com.kkopite.mvvmarchitecture.core.DataManager

/**
 * Created by kkopite on 2018/9/27.
 */

@AutoValue
abstract class Environment : Parcelable {

    abstract fun gson(): Gson
    abstract fun dataManager(): DataManager

    @AutoValue.Builder
    interface Builder {
        fun gson(gson: Gson): Builder
        fun dataManager(dataManager: DataManager): Builder
        fun build(): Environment
    }

    companion object {
        fun builder(): Builder = `$AutoValue_Environment`.Builder()

        fun create(gson: Gson, dataManager: DataManager): Environment {
            return builder().gson(gson)
                    .dataManager(dataManager)
                    .build()
        }
    }
}