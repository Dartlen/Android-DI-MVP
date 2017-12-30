package by.project.dartlen.android_di_mvp.music;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;

/***
 * Created by Dartlen on 30.12.2017.
 */
@ActivityScope
public class MusicPresenter implements MusicContract.Presenter{

    @NonNull
    private MusicContract.View mMusicView;

    @Inject
    MusicPresenter(){

    }

    @Override
    public void takeView(MusicContract.View view) {
        mMusicView = view;
    }

    @Override
    public void dropView() {
        mMusicView=null;
    }
}
