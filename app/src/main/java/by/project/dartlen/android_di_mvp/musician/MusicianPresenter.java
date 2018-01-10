package by.project.dartlen.android_di_mvp.musician;


import javax.annotation.Nullable;
import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.data.Repository;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;

/***
 * Created by Dartlen on 07.01.2018.
 */

public class MusicianPresenter implements MusicianContract.Presenter{

    @Nullable
    private MusicianContract.View mMusicianView;

    @Inject
    Repository mRepository;

    private Music dataMusic;

    @Inject
    MusicianPresenter(){}

    @Override
    public void takeView(MusicianContract.View view) {
        mMusicianView = view;
    }

    @Override
    public void dropView() {
        mMusicianView = null;
    }

    @Override
    public void start() {
        mMusicianView.showMusician(dataMusic);
    }

    @Override
    public void appenedMusic(Music data) {
        dataMusic = data;
    }
}
