package com.c1ctech.androiddagger2example.component;
import com.c1ctech.androiddagger2example.repository.MovieRepository;
import com.c1ctech.androiddagger2example.view.MovieActivity;
import com.c1ctech.androiddagger2example.module.ApiClientModule;
import com.c1ctech.androiddagger2example.module.AppModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ApiClientModule.class, AppModule.class})
public interface ApiComponent {
    void inject(MovieActivity movieActivity);
    void injectMovie(MovieRepository movieRepository);
}