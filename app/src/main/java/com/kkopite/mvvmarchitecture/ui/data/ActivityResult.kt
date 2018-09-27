package com.kkopite.mvvmarchitecture.ui.data

import android.content.Intent
import android.os.Parcelable
import com.google.auto.value.AutoValue

/**
 * Created by kkopite on 2018/9/27.
 */
@AutoValue
public abstract class ActivityResult: Parcelable {

    abstract fun requestCode(): Int
    abstract fun resultCode(): Int
    abstract fun intent(): Intent

    @AutoValue.Builder
    public interface Builder {
        fun requestCode(code: Int): Builder
        fun resultCode(code: Int): Builder
        fun intent(intent: Intent?): Builder
        fun build(): ActivityResult
    }

    companion object {
        fun create(requestCode: Int, resultCode: Int, intent:Intent?): ActivityResult {
            return builder()
                    .intent(intent)
                    .requestCode(requestCode)
                    .resultCode(resultCode)
                    .build()
        }

        private fun builder(): Builder {
            return `$AutoValue_ActivityResult`.Builder()
        }
    }

}