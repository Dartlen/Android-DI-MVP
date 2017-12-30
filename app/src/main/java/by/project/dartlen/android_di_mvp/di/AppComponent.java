package by.project.dartlen.android_di_mvp.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.data.Repository;
import by.project.dartlen.android_di_mvp.data.RepositoryModule;
import by.project.dartlen.android_di_mvp.di.main.ActivityBindingModule;
import by.project.dartlen.android_di_mvp.di.main.ApplicationModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/***
 * Created by Dartlen on 30.12.2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        RepositoryModule.class
       })
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    //void inject(App application);

    Repository getRepository();
    Context bindContext();
    /*@Override
    void inject(DaggerApplication instance);*/

    @Component.Builder
    interface  Builder{

        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}
