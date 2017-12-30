package by.project.dartlen.android_di_mvp.music;

import by.project.dartlen.android_di_mvp.BasePresenter;
import by.project.dartlen.android_di_mvp.BaseView;

/***
 * Created by Dartlen on 30.12.2017.
 */

public interface MusicContract {
    interface Presenter extends BasePresenter<MusicContract.View>{

    }
    interface View extends BaseView<MusicContract.Presenter>{

    }
}
