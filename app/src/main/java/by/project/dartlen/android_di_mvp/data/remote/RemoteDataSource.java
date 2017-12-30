package by.project.dartlen.android_di_mvp.data.remote;



import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.data.remote.retrofit.ApiFactory;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;
import retrofit2.Callback;

/***
 * Created by Dartlen on 30.12.2017.
 */
@Singleton
public class RemoteDataSource {

    @Inject
    public RemoteDataSource(){}

    public void getMusic(@NonNull Callback<List<Music>> callback){
        retrofit2.Call<List<Music>> call = ApiFactory.getYandexService().getMusic();
        call.enqueue(callback);
    }
}
