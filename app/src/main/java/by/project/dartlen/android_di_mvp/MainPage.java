package by.project.dartlen.android_di_mvp;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import by.project.dartlen.android_di_mvp.music.MusicFragment;
import dagger.android.support.DaggerAppCompatActivity;


public class MainPage extends DaggerAppCompatActivity {

    @Inject
    MusicFragment mMusicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment, mMusicFragment).addToBackStack("musicfragment").commit();

    }
}
