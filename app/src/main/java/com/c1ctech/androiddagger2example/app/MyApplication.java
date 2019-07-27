package com.c1ctech.androiddagger2example.app;
import android.app.Application;
import com.c1ctech.androiddagger2example.component.ApiComponent;
import com.c1ctech.androiddagger2example.component.DaggerApiComponent;
import com.c1ctech.androiddagger2example.module.ApiClientModule;
import com.c1ctech.androiddagger2example.module.AppModule;
import com.c1ctech.androiddagger2example.util.Constant;

public class MyApplication extends Application {

    public static ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiClientModule(new ApiClientModule(Constant.Api.BASE_URL))
                .build();
    }

    public static ApiComponent getComponent() {
        return mApiComponent;
    }
}