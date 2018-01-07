package by.project.dartlen.android_di_mvp.data;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.data.remote.GetMusicCallback;
import by.project.dartlen.android_di_mvp.data.remote.Remote;
import by.project.dartlen.android_di_mvp.data.remote.RemoteDataSource;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * Created by Dartlen on 30.12.2017.
 */

@Singleton
public class Repository {
    final private RemoteDataSource mRemoteDataSource;

    @Inject
    Repository(@Remote RemoteDataSource remoteDataSource){
        mRemoteDataSource = remoteDataSource;
    }

    public void getMusic(@NonNull final GetMusicCallback callback){
        /*mRemoteDataSource.getMusic(new Callback<List<Music>>() {
            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
                callback.onMusicLoaded(new ArrayList<Music>(response.body()));
            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {
                callback.onDataNotAvaliable(t.getMessage());
            }
        });*/

        mRemoteDataSource.getMusic(new Callback<List<Music>>() {
            @Override
            public void onResponse(@NonNull Call<List<Music>> call, @NonNull Response<List<Music>> response) {
                List<Music> x = response.body();
                callback.onMusicLoaded(x);
            }

            @Override
            public void onFailure(@NonNull Call<List<Music>> call, @NonNull Throwable t) {
                //Log.d("da",t.toString());
            }
        });
    }
}
