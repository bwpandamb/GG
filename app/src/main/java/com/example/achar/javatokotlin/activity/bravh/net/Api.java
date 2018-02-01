package com.example.achar.javatokotlin.activity.bravh.net;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ext.charles.ma on 18/1/11.
 */

public interface Api {

//    @Headers("Content-Type: application/json-patch+json")
    @GET("im/staff/{id}/groups")
    Observable<IMGroupResp> getIMGroup(@Path("id") String id);
}
