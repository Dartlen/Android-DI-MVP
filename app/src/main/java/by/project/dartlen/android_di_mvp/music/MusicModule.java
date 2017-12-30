package by.project.dartlen.android_di_mvp.music;

import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import by.project.dartlen.android_di_mvp.di.scopes.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/***
 * Created by Dartlen on 30.12.2017.
 */

@Module
public abstract class MusicModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract MusicFragment musicFragment();

    @ActivityScope
    @Binds abstract MusicContract.Presenter musicPresenter(MusicPresenter presenter);
}
