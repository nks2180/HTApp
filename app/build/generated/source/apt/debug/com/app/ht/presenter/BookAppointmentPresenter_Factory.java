package com.app.ht.presenter;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookAppointmentPresenter_Factory implements Factory<BookAppointmentPresenter> {
  private final MembersInjector<BookAppointmentPresenter> bookAppointmentPresenterMembersInjector;

  private final Provider<Context> baseContextProvider;

  public BookAppointmentPresenter_Factory(
      MembersInjector<BookAppointmentPresenter> bookAppointmentPresenterMembersInjector,
      Provider<Context> baseContextProvider) {
    assert bookAppointmentPresenterMembersInjector != null;
    this.bookAppointmentPresenterMembersInjector = bookAppointmentPresenterMembersInjector;
    assert baseContextProvider != null;
    this.baseContextProvider = baseContextProvider;
  }

  @Override
  public BookAppointmentPresenter get() {
    return MembersInjectors.injectMembers(
        bookAppointmentPresenterMembersInjector,
        new BookAppointmentPresenter(baseContextProvider.get()));
  }

  public static Factory<BookAppointmentPresenter> create(
      MembersInjector<BookAppointmentPresenter> bookAppointmentPresenterMembersInjector,
      Provider<Context> baseContextProvider) {
    return new BookAppointmentPresenter_Factory(
        bookAppointmentPresenterMembersInjector, baseContextProvider);
  }
}
