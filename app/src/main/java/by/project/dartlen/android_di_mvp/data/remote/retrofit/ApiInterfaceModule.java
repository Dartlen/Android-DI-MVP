package by.project.dartlen.android_di_mvp.data.remote.retrofit;

import by.project.dartlen.android_di_mvp.Constant;
import by.project.dartlen.android_di_mvp.di.main.ApplicationModule;

import by.project.dartlen.android_di_mvp.di.main.NetworkModule;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by Dartlen on 07.01.2018.
 */

@Module(includes = {NetworkModule.class, ApplicationModule.class})
public class ApiInterfaceModule {

    @Provides
    public Retrofit provideTetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constant.ROOT_URL)
                .build();
    }

    @Provides
    public YandexService provideApiInterface(Retrofit retrofit){
        return retrofit.create(YandexService.class);
    }
}
