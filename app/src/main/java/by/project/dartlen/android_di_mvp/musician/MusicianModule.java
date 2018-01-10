package by.project.dartlen.android_di_mvp.musician;

import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import by.project.dartlen.android_di_mvp.di.scopes.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/***
 * Created by Dartlen on 07.01.2018.
 */

@Module
public abstract class MusicianModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract MusicianFragment musicianFragment();

    @ActivityScope
    @Binds abstract MusicianContract.Presenter musicianPresenter(MusicianPresenter presetner);
}
