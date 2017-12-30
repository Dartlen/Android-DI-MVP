package by.project.dartlen.android_di_mvp;

/***
 * Created by Dartlen on 30.12.2017.
 */

public interface BasePresenter<T> {
    void takeView(T view);
    void dropView();
}
