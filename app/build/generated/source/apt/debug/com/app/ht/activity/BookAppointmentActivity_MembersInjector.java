package com.app.ht.activity;

import com.app.ht.presenter.BookAppointmentPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookAppointmentActivity_MembersInjector
    implements MembersInjector<BookAppointmentActivity> {
  private final Provider<BookAppointmentPresenter> bookAppointmentPresenterProvider;

  public BookAppointmentActivity_MembersInjector(
      Provider<BookAppointmentPresenter> bookAppointmentPresenterProvider) {
    assert bookAppointmentPresenterProvider != null;
    this.bookAppointmentPresenterProvider = bookAppointmentPresenterProvider;
  }

  public static MembersInjector<BookAppointmentActivity> create(
      Provider<BookAppointmentPresenter> bookAppointmentPresenterProvider) {
    return new BookAppointmentActivity_MembersInjector(bookAppointmentPresenterProvider);
  }

  @Override
  public void injectMembers(BookAppointmentActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.bookAppointmentPresenter = bookAppointmentPresenterProvider.get();
  }

  public static void injectBookAppointmentPresenter(
      BookAppointmentActivity instance,
      Provider<BookAppointmentPresenter> bookAppointmentPresenterProvider) {
    instance.bookAppointmentPresenter = bookAppointmentPresenterProvider.get();
  }
}
