package com.c1ctech.androiddagger2example.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import com.c1ctech.androiddagger2example.R;
import com.c1ctech.androiddagger2example.databinding.ActivityDetailseBinding;
import com.c1ctech.androiddagger2example.model.Movie;

public class DetailseActivity extends AppCompatActivity {
    private ActivityDetailseBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_detailse);
        Intent intent = getIntent();
        if (intent != null) {
            Movie movie = intent.getParcelableExtra("Movie");
            detailsBinding.setMovie(movie);
        }
    }
}
