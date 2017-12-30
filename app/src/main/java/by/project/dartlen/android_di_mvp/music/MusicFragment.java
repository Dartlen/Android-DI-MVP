package by.project.dartlen.android_di_mvp.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;
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

    @BindView(R.id.recycler_view)
    RecyclerView musicRecycler;

    private MusicAdapter musicAdapter;

    @Override
    public void onResume() {
        super.onResume();
        mMusicPresenter.takeView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_musics, container, false);

        ButterKnife.bind(this, root);

        musicAdapter = new MusicAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        musicRecycler.setLayoutManager(mLayoutManager);
        musicRecycler.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        musicRecycler.setAdapter(musicAdapter);

        mMusicPresenter.startedFragment();
        return root;
    }

    @Override
    public void showMusic(List<Music> data) {
        musicAdapter.setMusicData(data);
        musicAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessateToast(String message, int timeMessage) {
        Toast.makeText(getContext(), message, timeMessage).show();
    }
}
