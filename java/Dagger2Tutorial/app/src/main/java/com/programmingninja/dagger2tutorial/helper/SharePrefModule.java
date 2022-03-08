package com.programmingninja.dagger2tutorial.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharePrefModule {
    private Context cx;

    public SharePrefModule(Context context) {
        this.cx = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return cx
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

}
