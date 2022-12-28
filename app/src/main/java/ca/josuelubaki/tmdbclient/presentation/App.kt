package ca.josuelubaki.tmdbclient.presentation

import android.app.Application
import ca.josuelubaki.tmdbclient.BuildConfig
import ca.josuelubaki.tmdbclient.presentation.di.Injector
import ca.josuelubaki.tmdbclient.presentation.di.artist.ArtistSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.core.AppComponent
import ca.josuelubaki.tmdbclient.presentation.di.core.AppModule
import ca.josuelubaki.tmdbclient.presentation.di.core.DaggerAppComponent
import ca.josuelubaki.tmdbclient.presentation.di.core.NetModule
import ca.josuelubaki.tmdbclient.presentation.di.core.RemoteDataModule
import ca.josuelubaki.tmdbclient.presentation.di.movie.MovieSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}