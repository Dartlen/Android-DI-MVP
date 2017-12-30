package by.project.dartlen.android_di_mvp.music;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder>{
    private List<Music> dataMusic;

    public MusicAdapter(){}

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);

        return new MusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        holder.nameTextView.setText(dataMusic.get(position).getName());
        holder.bind(dataMusic.get(position).getCover().getSmall());
        holder.genreTextView.setText((dataMusic.get(position).getGenres()).toString());
        holder.countsTextView.setText(dataMusic.get(position).getAlbums().toString()+" alboms,"+
        dataMusic.get(position).getTracks()+"tracks.");
    }

    @Override
    public int getItemCount() {
        if(dataMusic == null)
            return 0;
        else
            return dataMusic.size();
    }

    public void setMusicData(List<Music> data){
        dataMusic = data;
    }
}
