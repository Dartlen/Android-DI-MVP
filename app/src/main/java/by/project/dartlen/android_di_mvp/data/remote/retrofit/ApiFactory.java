package by.project.dartlen.android_di_mvp.data.remote.retrofit;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/***
 * Created by Dartlen on 30.12.2017.
 */

public final class ApiFactory {
    private static String ROOT_URL = "http://download.cdn.yandex.net";
    private static OkHttpClient sClient;
    private static volatile YandexService sService;

    private ApiFactory(){}

    @NonNull
    public static YandexService getYandexService(){
        YandexService service = sService;
        if(service == null){
            synchronized (ApiFactory.class){
                service = sService;
                if(service == null){
                    service = sService = buildRetrofit().create(YandexService.class);
                }
            }
        }
        return service;
    }

    @NonNull
    private static Retrofit buildRetrofit(){

        Gson gson = new GsonBuilder()
                .create();


        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @NonNull
    private static OkHttpClient getClient(){
        OkHttpClient client = sClient;
        if(client == null){
            synchronized (ApiFactory.class){
                client = sClient;
                if (client == null){
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new ApiKeyInterceptor())
                .build();
    }
}
