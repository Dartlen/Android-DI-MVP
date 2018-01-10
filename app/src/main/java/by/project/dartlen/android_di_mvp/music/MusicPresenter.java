package by.project.dartlen.android_di_mvp.music;

import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.data.Repository;
import by.project.dartlen.android_di_mvp.data.remote.GetMusicCallback;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class MusicPresenter implements MusicContract.Presenter{

    private List<Music> data;

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
                data = musicList;
                mMusicView.showMusic(musicList);
            }

            @Override
            public void onDataNotAvaliable(String error) {
                mMusicView.showMessateToast(error, Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public void onItemClickedItem(int position) {
        mMusicView.showItem(data.get(position));
    }
}
