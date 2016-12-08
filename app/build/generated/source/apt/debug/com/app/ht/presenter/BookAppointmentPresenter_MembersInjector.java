package com.app.ht.presenter;

import com.app.ht.executor.ParsingExecutor;
import com.app.ht.retrofit.ApiController;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookAppointmentPresenter_MembersInjector
    implements MembersInjector<BookAppointmentPresenter> {
  private final Provider<ApiController> apiControllerProvider;

  private final Provider<ParsingExecutor> parsingExecutorProvider;

  public BookAppointmentPresenter_MembersInjector(
      Provider<ApiController> apiControllerProvider,
      Provider<ParsingExecutor> parsingExecutorProvider) {
    assert apiControllerProvider != null;
    this.apiControllerProvider = apiControllerProvider;
    assert parsingExecutorProvider != null;
    this.parsingExecutorProvider = parsingExecutorProvider;
  }

  public static MembersInjector<BookAppointmentPresenter> create(
      Provider<ApiController> apiControllerProvider,
      Provider<ParsingExecutor> parsingExecutorProvider) {
    return new BookAppointmentPresenter_MembersInjector(
        apiControllerProvider, parsingExecutorProvider);
  }

  @Override
  public void injectMembers(BookAppointmentPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.apiController = apiControllerProvider.get();
    instance.parsingExecutor = parsingExecutorProvider.get();
  }

  public static void injectApiController(
      BookAppointmentPresenter instance, Provider<ApiController> apiControllerProvider) {
    instance.apiController = apiControllerProvider.get();
  }

  public static void injectParsingExecutor(
      BookAppointmentPresenter instance, Provider<ParsingExecutor> parsingExecutorProvider) {
    instance.parsingExecutor = parsingExecutorProvider.get();
  }
}
