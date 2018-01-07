package by.project.dartlen.android_di_mvp.utils;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import by.project.dartlen.android_di_mvp.R;
import by.project.dartlen.android_di_mvp.di.scopes.ActivityScope;

/***
 * Created by Dartlen on 30.12.2017.
 */

@ActivityScope
public class UtilPicasso {

    public UtilPicasso(){}

    public static void loadImage(@NonNull final ImageView imageView, @NonNull final String url) {

        Picasso.with(imageView.getContext())
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                        Picasso.with(imageView.getContext())
                                .load(url)
                                .error(R.drawable.ic_launcher_background)
                                .into(imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {

                                    }
                                });
                    }
                });
    }
}
