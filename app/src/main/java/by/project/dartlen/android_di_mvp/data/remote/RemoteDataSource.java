package by.project.dartlen.android_di_mvp.data.remote;



import java.util.List;

import by.project.dartlen.android_di_mvp.data.remote.retrofit.ApiFactory;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;
import retrofit2.Callback;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class RemoteDataSource {

    public void getMusic(Callback<List<Music>> callback){
        retrofit2.Call<List<Music>> call = ApiFactory.getYandexService().getMusic();
        call.enqueue(callback);

    }
}
