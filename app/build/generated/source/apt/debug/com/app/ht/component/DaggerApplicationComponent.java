package com.app.ht.component;

import android.content.Context;
import com.app.ht.MaterialApplication;
import com.app.ht.activity.BookAppointmentActivity;
import com.app.ht.activity.BookAppointmentActivity_MembersInjector;
import com.app.ht.activity.HomeActivity;
import com.app.ht.activity.HomeActivity_MembersInjector;
import com.app.ht.executor.ParsingExecutor;
import com.app.ht.module.ApplicationModule;
import com.app.ht.module.ApplicationModule_ProvideApplicationContextFactory;
import com.app.ht.module.ApplicationModule_ProvidesParsingExecutorFactory;
import com.app.ht.module.DatabaseModule;
import com.app.ht.module.NetModule;
import com.app.ht.module.NetModule_ProvideApiServiceFactory;
import com.app.ht.module.NetModule_ProvideConverterFactory;
import com.app.ht.module.NetModule_ProvideOkHttpClientFactory;
import com.app.ht.module.NetModule_ProvideRetrofitFactory;
import com.app.ht.module.NetModule_ProvidesApiControllerFactory;
import com.app.ht.presenter.BookAppointmentPresenter;
import com.app.ht.presenter.BookAppointmentPresenter_Factory;
import com.app.ht.presenter.BookAppointmentPresenter_MembersInjector;
import com.app.ht.presenter.HomePresenter;
import com.app.ht.presenter.HomePresenter_Factory;
import com.app.ht.presenter.HomePresenter_MembersInjector;
import com.app.ht.retrofit.ApiController;
import com.app.ht.retrofit.ApiService;
import com.app.ht.retrofit.ToStringConverter;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<ToStringConverter> provideConverterProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private Provider<ApiController> providesApiControllerProvider;

  private Provider<ParsingExecutor> providesParsingExecutorProvider;

  private MembersInjector<HomePresenter> homePresenterMembersInjector;

  private Provider<HomePresenter> homePresenterProvider;

  private MembersInjector<HomeActivity> homeActivityMembersInjector;

  private MembersInjector<BookAppointmentPresenter> bookAppointmentPresenterMembersInjector;

  private Provider<BookAppointmentPresenter> bookAppointmentPresenterProvider;

  private MembersInjector<BookAppointmentActivity> bookAppointmentActivityMembersInjector;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationContextFactory.create(builder.applicationModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            NetModule_ProvideOkHttpClientFactory.create(
                builder.netModule, provideApplicationContextProvider));

    this.provideConverterProvider =
        DoubleCheck.provider(NetModule_ProvideConverterFactory.create(builder.netModule));

    this.provideRetrofitProvider =
        DoubleCheck.provider(
            NetModule_ProvideRetrofitFactory.create(
                builder.netModule, provideOkHttpClientProvider, provideConverterProvider));

    this.provideApiServiceProvider =
        DoubleCheck.provider(
            NetModule_ProvideApiServiceFactory.create(builder.netModule, provideRetrofitProvider));

    this.providesApiControllerProvider =
        DoubleCheck.provider(
            NetModule_ProvidesApiControllerFactory.create(
                builder.netModule, provideApiServiceProvider));

    this.providesParsingExecutorProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidesParsingExecutorFactory.create(builder.applicationModule));

    this.homePresenterMembersInjector =
        HomePresenter_MembersInjector.create(
            providesApiControllerProvider, providesParsingExecutorProvider);

    this.homePresenterProvider =
        HomePresenter_Factory.create(
            homePresenterMembersInjector, provideApplicationContextProvider);

    this.homeActivityMembersInjector = HomeActivity_MembersInjector.create(homePresenterProvider);

    this.bookAppointmentPresenterMembersInjector =
        BookAppointmentPresenter_MembersInjector.create(
            providesApiControllerProvider, providesParsingExecutorProvider);

    this.bookAppointmentPresenterProvider =
        BookAppointmentPresenter_Factory.create(
            bookAppointmentPresenterMembersInjector, provideApplicationContextProvider);

    this.bookAppointmentActivityMembersInjector =
        BookAppointmentActivity_MembersInjector.create(bookAppointmentPresenterProvider);
  }

  @Override
  public void inject(MaterialApplication materialApplication) {
    MembersInjectors.<MaterialApplication>noOp().injectMembers(materialApplication);
  }

  @Override
  public void inject(HomeActivity homeActivity) {
    homeActivityMembersInjector.injectMembers(homeActivity);
  }

  @Override
  public void inject(BookAppointmentActivity bookAppointmentActivity) {
    bookAppointmentActivityMembersInjector.injectMembers(bookAppointmentActivity);
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private NetModule netModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (netModule == null) {
        throw new IllegalStateException(NetModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }
  }
}