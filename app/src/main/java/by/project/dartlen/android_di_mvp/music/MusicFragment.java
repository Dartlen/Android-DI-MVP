package by.project.dartlen.android_di_mvp.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import dagger.android.support.DaggerFragment;

/***
 * Created by Dartlen on 30.12.2017.
 */
@ActivityScope
public class MusicFragment extends DaggerFragment implements MusicContract.View{

    @Inject
    public MusicFragment(){}

    @Inject
    MusicContract.Presenter mMusicPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_musics, container, false);
    }
}
