package by.project.dartlen.android_di_mvp;

import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.data.Repository;
import by.project.dartlen.android_di_mvp.di.AppComponent;
import by.project.dartlen.android_di_mvp.di.DaggerAppComponent;
import dagger.android.AndroidInjector;

import dagger.android.support.DaggerApplication;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class App extends DaggerApplication{

    @Inject
    Repository mRepository;

    @Override
    protected AndroidInjector<? extends  DaggerApplication> applicationInjector(){
        AppComponent appComponets = DaggerAppComponent.builder().application(this).build();
        appComponets.inject(this);
        return appComponets;
    }

}
