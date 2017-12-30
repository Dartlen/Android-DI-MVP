package by.project.dartlen.android_di_mvp.music;

import java.util.List;

import by.project.dartlen.android_di_mvp.BasePresenter;
import by.project.dartlen.android_di_mvp.BaseView;
import by.project.dartlen.android_di_mvp.data.remote.retrofit.Music;

/***
 * Created by Dartlen on 30.12.2017.
 */

public interface MusicContract {
    interface Presenter extends BasePresenter<MusicContract.View>{
        void startedFragment();
    }
    interface View extends BaseView<MusicContract.Presenter>{
        void showMusic(List<Music> data);
        void showMessateToast(String message, int timeMessage);
    }
}
