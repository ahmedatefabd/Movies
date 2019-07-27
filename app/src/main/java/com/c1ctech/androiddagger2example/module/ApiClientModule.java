package com.c1ctech.androiddagger2example.module;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module //created for return new Retrofit.Builder()
public class ApiClientModule {

    public final String BASE_URL;

    //Constructor
    public ApiClientModule(String url) {
        this.BASE_URL = url;
    }

    @Provides
    @Singleton
    Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}