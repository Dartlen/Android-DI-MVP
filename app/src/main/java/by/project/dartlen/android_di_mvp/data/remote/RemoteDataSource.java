package by.project.dartlen.android_di_mvp.data.remote;



import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.data.remote.model.Music;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.YandexService;
import retrofit2.Callback;

/***
 * Created by Dartlen on 30.12.2017.
 */

@Singleton
public class RemoteDataSource {

    @Inject
    public RemoteDataSource(){}

    @Inject
    YandexService mYandexService;


    public void getMusic(@NonNull Callback<List<Music>> callback){
        retrofit2.Call<List<Music>> call = mYandexService.getMusic();
        call.enqueue(callback);
    }
}
