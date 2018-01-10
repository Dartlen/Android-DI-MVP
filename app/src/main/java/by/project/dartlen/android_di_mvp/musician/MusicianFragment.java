package by.project.dartlen.android_di_mvp.musician;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;
import dagger.android.support.DaggerFragment;

/***
 * Created by Dartlen on 07.01.2018.
 */

@ActivityScope
public class MusicianFragment extends DaggerFragment implements MusicianContract.View {

    @Inject
    public MusicianFragment(){}

    @Inject
    MusicianContract.Presenter mMusicianPresenter;

    @BindView(R.id.style)
    TextView style;

    @BindView(R.id.imageView2)
    ImageView image;

    @BindView(R.id.alboms)
    TextView alboms;

    @BindView(R.id.descriptions)
    TextView descriptions;

    @BindView(R.id.song)
    TextView song;

    @Inject
    Picasso mPicasso;

    private Toolbar toolbar;

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMusicianPresenter.takeView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_musician, container, false);
        ButterKnife.bind(this, root);

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .popBackStack();
            }
        });
        mMusicianPresenter.start();
        return root;
    }

    @Override
    public void showMusician(final Music dataMusic) {
        mPicasso.setIndicatorsEnabled(true);

        mPicasso.load(dataMusic.getCover().getBig())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .placeholder(R.drawable.progress_animation)
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                        mPicasso.load(dataMusic.getCover().getBig())
                                .error(R.drawable.ic_launcher_background)
                                .into(image, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {

                                    }
                                });
                    }
                });

        style.setText(dataMusic.getGenres().toString().substring(1,dataMusic.getGenres().toString().length()-1));

        descriptions.setText(dataMusic.getDescription());

        toolbar.setTitle(dataMusic.getName());

        alboms.setText(dataMusic.getAlbums()+" альбомов, ");


        song.setText(dataMusic.getTracks()+" песен");
    }

    @Override
    public void appendMusic(final Music data) {
        mMusicianPresenter.appenedMusic(data);
    }
}
