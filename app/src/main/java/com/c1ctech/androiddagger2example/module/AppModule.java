package com.c1ctech.androiddagger2example.module;
import android.app.Application;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module //created for return Application = Context
public class AppModule {

    private Application mApplication;

    //Constructor
    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application getApplication() {
        return mApplication;
    }

}
