package by.project.dartlen.android_di_mvp;

import by.project.dartlen.android_di_mvp.di.AppComponet;
import by.project.dartlen.android_di_mvp.di.DaggerAppComponet;
import dagger.android.AndroidInjector;

import dagger.android.support.DaggerApplication;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class App extends DaggerApplication{

    @Override
    protected AndroidInjector<? extends  DaggerApplication> applicationInjector(){
        AppComponet appComponets = DaggerAppComponet.builder().application(this).build();
        appComponets.inject(this);
        return appComponets;
    }

}
