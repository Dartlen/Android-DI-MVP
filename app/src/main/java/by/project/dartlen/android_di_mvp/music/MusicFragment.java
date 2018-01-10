package by.project.dartlen.android_di_mvp.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import by.project.dartlen.android_di_mvp.musician.MusicianFragment;
import by.project.dartlen.android_di_mvp.musician.MusicianPresenter;
import dagger.Lazy;
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

    @Inject
    Picasso mPicasso;

    @Inject
    MusicianPresenter musicianPresenter;

    @Inject
    Lazy<MusicianFragment> MusicianFragmentprovider;

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
        Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(null);
        ItemClickSupport.addTo(musicRecycler)
                        .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                            @Override
                            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                                mMusicPresenter.onItemClickedItem(position);
                            }
                        });

        musicAdapter = new MusicAdapter(mPicasso);
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

    @Override
    public void showItem(Music music) {
        MusicianFragment x = MusicianFragmentprovider.get();
        x.appendMusic(music);
        getActivity().getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.fragment, x)
                     .addToBackStack("musicianitem")
                     .commit();
    }
}