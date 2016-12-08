package com.app.ht;

import android.app.Application;

import com.app.ht.component.ApplicationComponent;
import com.app.ht.component.DaggerApplicationComponent;
import com.app.ht.module.ApplicationModule;
import com.app.ht.module.DatabaseModule;
import com.app.ht.module.NetModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by niranjan on 03/11/16.
 */
public class MaterialApplication extends Application {

    private static final String BASE_URL = "http://108.healthifyme.com/";

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setApplicationComponent();
    }

    private void setApplicationComponent() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(BASE_URL))
                .databaseModule(new DatabaseModule(this))
                .build();

        mComponent.inject(this);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
