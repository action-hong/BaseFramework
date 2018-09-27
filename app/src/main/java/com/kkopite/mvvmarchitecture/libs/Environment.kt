package com.kkopite.mvvmarchitecture.libs

import android.os.Parcelable
import com.google.auto.value.AutoValue
import com.google.gson.Gson

/**
 * Created by kkopite on 2018/9/27.
 */

@AutoValue
abstract class Environment : Parcelable {

    abstract fun gson(): Gson

    @AutoValue.Builder
    interface Builder {
        fun gson(gson: Gson): Builder
        fun build(): Environment
    }

    companion object {
        fun builder(): Builder = `$AutoValue_Environment`.Builder()

        fun create(gson: Gson): Environment {
            return builder().gson(gson).build()
        }
    }
}