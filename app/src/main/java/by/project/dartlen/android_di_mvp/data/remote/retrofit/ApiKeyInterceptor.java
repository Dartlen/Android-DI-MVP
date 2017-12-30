package by.project.dartlen.android_di_mvp.data.remote.retrofit;

import android.view.animation.Interpolator;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/***
 * Created by Dartlen on 30.12.2017.
 */

public class ApiKeyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl originalUrl = chain.request().url();
        String query = originalUrl.encodedQuery();
        request.url().toString();
        HttpUrl url = request.url().newBuilder()
                .build();
        request = request.newBuilder().url(url).build();

        return chain.proceed(request);
    }
}
