package com.skh.newapp_java.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.skh.newapp_java.api.ApiClient;
import com.skh.newapp_java.api.ApiService;
import com.skh.newapp_java.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel  extends ViewModel {
    MutableLiveData<News> results = new MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResults() {
        return results;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }
    public  void loadResults(){
        loading.setValue(true);
        String apikey = "0bca4c6ac5bd43c29f47ddbbaa0edcee";
        Call<News> newsCall = ApiService.getNews("us","business", apikey);


        newsCall.enqueue((new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body() != null) {
                    loading.setValue(false);
                    results.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                loading.setValue(false);
                loadError.setValue(true);
            }
        }));
    }
}
