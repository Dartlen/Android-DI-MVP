package by.project.dartlen.android_di_mvp.di.main;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/***
 * Created by Dartlen on 30.12.2017.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

}

