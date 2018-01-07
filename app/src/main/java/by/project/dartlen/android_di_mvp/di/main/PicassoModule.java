package by.project.dartlen.android_di_mvp.di.main;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/***
 * Created by Dartlen on 07.01.2018.
 */
@Module(includes = {NetworkModule.class, ApplicationModule.class})
public class PicassoModule {

    @Provides
    public OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    public Picasso providePicasso(Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

}
