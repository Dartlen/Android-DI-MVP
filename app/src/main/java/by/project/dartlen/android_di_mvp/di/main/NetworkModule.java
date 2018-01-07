package by.project.dartlen.android_di_mvp.di.main;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/***
 * Created by Dartlen on 07.01.2018.
 */
@Module(includes = ApplicationModule.class)
public class NetworkModule {

    @Provides
    public File provideCacheFile(Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    public Cache provideCache(File cacheFile){
        return new Cache(cacheFile, 10*1000*1000);
    }

    @Provides
    public OkHttpClient provideOkhttpClient(Cache cache){
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }
}
