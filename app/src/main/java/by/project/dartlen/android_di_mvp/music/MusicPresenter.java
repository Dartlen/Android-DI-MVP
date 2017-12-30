package by.project.dartlen.android_di_mvp.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.data.Repository;
import by.project.dartlen.android_di_mvp.data.remote.GetMusicCallback;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import by.project.dartlen.android_di_mvp.utils.UtilPicasso;

/***
 * Created by Dartlen on 30.12.2017.
 */

@ActivityScope
public class MusicPresenter implements MusicContract.Presenter{

    @Nullable
    private MusicContract.View mMusicView;

    @Inject
    Repository mRepository;

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

    @Override
    public void startedFragment() {
        mRepository.getMusic(new GetMusicCallback() {
            @Override
            public void onMusicLoaded(List<Music> musicList) {
                mMusicView.showMusic(musicList);
            }

            @Override
            public void onDataNotAvaliable(String error) {
                mMusicView.showMessateToast(error, Toast.LENGTH_LONG);
            }
        });
    }
}
