package com.app.ht.component;

import com.app.ht.HTApplication;
import com.app.ht.activity.BookAppointmentActivity;
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

    void inject(HTApplication materialApplication);


    void inject(BookAppointmentActivity bookAppointmentActivity);
}
