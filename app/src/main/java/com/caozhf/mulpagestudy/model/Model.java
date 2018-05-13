package com.caozhf.mulpagestudy.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by CaoZhF on 2018-05-11.
 */

public class Model {

    private IMP imp;

    public Model(IMP imp) {
        this.imp = imp;
    }

    public void OKHTTPData(String get_url){
        OkHttpClient client = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url(get_url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                imp.FailureGet(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                imp.SuccessGet(response.body().string());
            }
        });
    }

}
