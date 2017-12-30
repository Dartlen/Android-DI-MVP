package by.project.dartlen.android_di_mvp.di.main;

import by.project.dartlen.android_di_mvp.MainPage;
import by.project.dartlen.android_di_mvp.data.RepositoryModule;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import by.project.dartlen.android_di_mvp.music.MusicModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/***
 * Created by Dartlen on 30.12.2017.
 */

@Module
public abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {MusicModule.class, RepositoryModule.class})
    abstract MainPage mainPage();
}
