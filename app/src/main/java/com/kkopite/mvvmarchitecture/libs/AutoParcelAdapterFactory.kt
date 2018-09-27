package com.kkopite.mvvmarchitecture.libs

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.kkopite.mvvmarchitecture.libs.qualifiers.AutoGson

/**
 *
 * Created by kkopite on 2018/9/27.
 */
public final class AutoParcelAdapterFactory: TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T>? {
        if (type == null) return null
        val rawType = type.rawType
        if (!rawType.isAnnotationPresent(AutoGson::class.java)) {
            return null
        }
        val packageName = rawType.`package`.name
        val className = rawType.name.substring(packageName.length + 1).replace('$', '_')
        val autoParcelName = "$packageName.AutoValue_$className"
        val clazz = Class.forName(autoParcelName)
        @Suppress("UNCHECKED_CAST")
        return gson?.getAdapter(clazz) as TypeAdapter<T>
    }

}