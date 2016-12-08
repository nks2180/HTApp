package com.app.ht.component;

import com.app.ht.MaterialApplication;
import com.app.ht.activity.BookAppointmentActivity;
import com.app.ht.activity.HomeActivity;
import com.app.ht.module.ApplicationModule;
import com.app.ht.module.DatabaseModule;
import com.app.ht.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by niranjan on 03/11/16.
 */
@Singleton
@Component(modules={ApplicationModule.class, NetModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(MaterialApplication materialApplication);

    void inject(HomeActivity homeActivity);

    void inject(BookAppointmentActivity bookAppointmentActivity);
}
