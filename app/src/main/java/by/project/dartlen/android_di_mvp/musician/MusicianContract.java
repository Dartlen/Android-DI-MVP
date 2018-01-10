package by.project.dartlen.android_di_mvp.musician;

import by.project.dartlen.android_di_mvp.BasePresenter;
import by.project.dartlen.android_di_mvp.BaseView;
import by.project.dartlen.android_di_mvp.data.remote.model.Music;

/***
 * Created by Dartlen on 07.01.2018.
 */

public interface MusicianContract {
    interface Presenter extends BasePresenter<MusicianContract.View>{
        void appenedMusic(Music data);
        void start();
    }
    interface View extends BaseView<MusicianContract.Presenter>{
        void appendMusic(Music data);
        void showMusician(Music data);
    }
}
