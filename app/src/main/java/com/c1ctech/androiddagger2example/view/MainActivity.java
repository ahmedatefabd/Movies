package com.c1ctech.androiddagger2example.view;
import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.c1ctech.androiddagger2example.R;
import com.c1ctech.androiddagger2example.adapter.MovieAdapter;
import com.c1ctech.androiddagger2example.app.MyApplication;
import com.c1ctech.androiddagger2example.databinding.ActivityMainBinding;
import com.c1ctech.androiddagger2example.model.Movie;
import com.c1ctech.androiddagger2example.model.ResponseMovie;
import com.c1ctech.androiddagger2example.viewmodel.MovieViewModel;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private ActivityMainBinding binding;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((MyApplication) getApplication()).getComponent().inject(this);
        binding.setLifecycleOwner(this);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovies(this);
        observableChanges();
    }

    private void observableChanges() {
        movieViewModel.movieList.observe(this, new Observer<ResponseMovie>() {
                    @Override
                    public void onChanged(ResponseMovie responseMovie) {
                        Recycler(responseMovie.getMovies());
                    }
                }
        );

        movieViewModel.errorMessage.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

        movieViewModel.showLoadingProg.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show) {
                if (show)
                    showLoadingBar();
                else
                    hideLoadingBar();
            }
        });
    }

    private void showLoadingBar() {
        binding.loadignBar.setVisibility(View.VISIBLE);
    }

    private void hideLoadingBar() {
        binding.loadignBar.setVisibility(View.INVISIBLE);
    }

    private void Recycler(List<Movie> movies) {
        binding.setAdapter(new MovieAdapter(movies, MainActivity.this));
    }
}