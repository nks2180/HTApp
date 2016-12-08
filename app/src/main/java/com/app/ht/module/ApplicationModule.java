package com.app.ht.module;

import android.content.Context;

import com.app.ht.HTApplication;
import com.app.ht.executor.ParsingExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by niranjan on 03/11/16.
 */
@Module
public class ApplicationModule {

    private final HTApplication lybrate;

    public ApplicationModule(HTApplication lybrate) {
        this.lybrate = lybrate;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return lybrate;
    }

    @Provides
    @Singleton
    ParsingExecutor providesParsingExecutor() {
        return new ParsingExecutor();
    }

}
