package by.project.dartlen.android_di_mvp.data.remote.retrofit;

import java.util.List;

import by.project.dartlen.android_di_mvp.data.remote.model.Music;
import retrofit2.Call;
import retrofit2.http.GET;

/***
 * Created by Dartlen on 30.12.2017.
 */

public interface YandexService {
    @GET("/mobilization-2016/artists.json")
    Call<List<Music>> getMusic();
}
