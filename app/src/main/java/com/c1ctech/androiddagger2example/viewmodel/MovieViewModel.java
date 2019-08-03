package com.c1ctech.androiddagger2example.viewmodel;
import android.app.Application;
import com.c1ctech.androiddagger2example.model.ResponseMovie;
import com.c1ctech.androiddagger2example.repository.MovieRepository;
import com.c1ctech.androiddagger2example.util.Connection;
import com.c1ctech.androiddagger2example.util.Constant;
import java.util.HashMap;
import java.util.Map;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MovieViewModel extends AndroidViewModel {
    public MutableLiveData<ResponseMovie> movieList = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
//    public MutableLiveData<Boolean> showLoadingProg = new MutableLiveData<>();
    private MovieRepository movieRepository = new MovieRepository();
    private boolean isConnected;

    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMovies() {
//        showLoadingProg.setValue(true);
        isConnected = Connection.isNetworkAvailable(getApplication());
        if (isConnected) {
//            showLoadingProg.setValue(false);
            Map<String, String> map = new HashMap<>();
            map.put(Constant.Api.TOKEN_NAME, Constant.Api.TOKEN_VALUE);
            movieList = movieRepository.getMovies(map);
//            showLoadingProg.setValue(false);
        } else {
            errorMessage.setValue("No internet Connection");
//            showLoadingProg.setValue(false);
        }
    }
}