package com.c1ctech.androiddagger2example.repository;
import android.app.Application;
import com.c1ctech.androiddagger2example.api.ApiInterface;
import com.c1ctech.androiddagger2example.app.MyApplication;
import com.c1ctech.androiddagger2example.model.ResponseMovie;
import java.util.Map;
import javax.inject.Inject;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.c1ctech.androiddagger2example.view.MovieActivity.progressDialog;

public class MovieRepository {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private static MovieRepository repository;
    private ApiInterface apiInterface ;

    public static MovieRepository getInstance(){
        if (repository == null){
            repository = new MovieRepository();
        }
        return repository;
    }

    public MovieRepository(){
        MyApplication.getComponent().injectMovie(this);
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public MutableLiveData<ResponseMovie> getMovies(Map<String , String> stringMap){
        MutableLiveData<ResponseMovie> responseMovieMutableLiveData = new MutableLiveData<>();
        apiInterface.getMovies(stringMap).enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    responseMovieMutableLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                progressDialog.dismiss();
                responseMovieMutableLiveData.setValue(null);
            }
        });
        return responseMovieMutableLiveData;
    }
}