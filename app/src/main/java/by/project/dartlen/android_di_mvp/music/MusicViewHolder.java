package by.project.dartlen.android_di_mvp.music;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.utils.UtilPicasso;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class MusicViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.name)
    TextView nameTextView;

    @BindView(R.id.music_image)
    ImageView musicImageView;

    @BindView(R.id.genre)
    TextView genreTextView;

    @BindView(R.id.counts)
    TextView countsTextView;


    public MusicViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }

    /*public void bind(@NonNull String url) {
        UtilPicasso.loadImage(musicImageView, url);
    }*/
}
