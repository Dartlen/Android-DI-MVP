package by.project.dartlen.android_di_mvp.di;

import android.app.Application;

import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.App;
import by.project.dartlen.android_di_mvp.di.main.ActivityBindingModule;
import by.project.dartlen.android_di_mvp.di.main.ApplicationModule;
import by.project.dartlen.android_di_mvp.music.MusicModule;
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
        AndroidSupportInjectionModule.class})
public interface AppComponet extends AndroidInjector<DaggerApplication> {
    void inject(App application);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface  Builder{
        @BindsInstance
        AppComponet.Builder application(Application application);
        AppComponet build();
    }
}
