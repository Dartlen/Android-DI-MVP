package by.project.dartlen.android_di_mvp.data;

import javax.inject.Singleton;

import by.project.dartlen.android_di_mvp.data.remote.Remote;
import by.project.dartlen.android_di_mvp.data.remote.RemoteDataSource;
import dagger.Binds;
import dagger.Module;

/***
 * Created by Dartlen on 30.12.2017.
 */
@Module
public abstract class RepositoryModule {

    @Singleton
    @Binds
    @Remote
    abstract RemoteDataSource providerRemoteDataSource(RemoteDataSource remoteDataSource);

}
