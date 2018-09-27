package com.kkopite.mvvmarchitecture

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kkopite.mvvmarchitecture.libs.ApiClient
import com.kkopite.mvvmarchitecture.libs.ApiClientType
import com.kkopite.mvvmarchitecture.libs.AutoParcelAdapterFactory
import com.kkopite.mvvmarchitecture.libs.Environment
import com.kkopite.mvvmarchitecture.services.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import kotlin.reflect.jvm.internal.impl.javax.inject.Singleton

/**
 * Created by kkopite on 2018/9/27.
 */
@Module
public class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideEnvironment(gson: Gson): Environment {
            return Environment.builder()
                    .gson(gson)
                    .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideGson(): Gson {
            return GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeAdapterFactory(AutoParcelAdapterFactory())
                    .create()

        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideApiClientType(service: ApiService, gson: Gson): ApiClientType {
            return ApiClient(service, gson)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        // todo: 多个base url 自己的api, 工程师爸爸的api, 两个retrofit
        @JvmStatic
        @Provides
        @Singleton
        fun provideApiRetrofit(baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
            return createRetrofit(baseUrl, gson, okHttpClient)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideBaseUrl(): String {
            return "https://api.robospace.cc/"
        }

        // todo: 添加一些拦截
        @JvmStatic
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder().hostnameVerifier { hostname, _ ->
                Timber.d(hostname)
                return@hostnameVerifier true
            }.build()
        }

        private fun createRetrofit(url: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }

    }



}