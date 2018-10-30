package com.kkopite.mvvmarchitecture.libs

import com.google.gson.Gson
import com.kkopite.mvvmarchitecture.core.http.api.ApiService


/**
 * Created by kkopite on 2018/9/27.
 */
public class ApiClient(val service: ApiService, val gson: Gson): ApiClientType {

}