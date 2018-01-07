package by.project.dartlen.android_di_mvp.data.remote;

import java.util.List;

import by.project.dartlen.android_di_mvp.data.remote.model.Music;

/***
 * Created by Dartlen on 30.12.2017.
 */

public interface GetMusicCallback {
    void onMusicLoaded(List<Music> musicList);
    void onDataNotAvaliable(String error);
}
