package com.c1ctech.androiddagger2example.view;
import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.c1ctech.androiddagger2example.R;
import com.c1ctech.androiddagger2example.adapter.MovieAdapter;
import com.c1ctech.androiddagger2example.app.MyApplication;
import com.c1ctech.androiddagger2example.databinding.ActivityMainBinding;
import com.c1ctech.androiddagger2example.model.Movie;
import com.c1ctech.androiddagger2example.viewmodel.MovieViewModel;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class MovieActivity extends AppCompatActivity {
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
        movieViewModel.getMovies();
        observableChanges();
    }

    private void observableChanges() {
        movieViewModel.movieList.observe(this, responseMovie -> Recycler(responseMovie.getMovies()));

        movieViewModel.errorMessage.observe(this, s -> Toast.makeText(MovieActivity.this, s, Toast.LENGTH_LONG).show());

        movieViewModel.showLoadingProg.observe(this, show -> {
            if (show)
                showLoadingBar();
            else
                hideLoadingBar();
        });
    }

    private void showLoadingBar() {
        binding.loadignBar.setVisibility(View.VISIBLE);
    }

    private void hideLoadingBar() {
        binding.loadignBar.setVisibility(View.INVISIBLE);
    }

    private void Recycler(List<Movie> movies) {
        binding.setAdapter(new MovieAdapter(movies, MovieActivity.this));
    }
}