package com.prashant.freemiumnews.di

import com.prashant.freemiumnews.NewsApp
import com.prashant.freemiumnews.common.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        NetworkModule::class
    )
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun app(app: NewsApp): Builder

        @BindsInstance
        fun networkModule(module: NetworkModule): Builder
    }

    fun inject(app: NewsApp)

    fun getViewModelFactory(): ViewModelFactory
}