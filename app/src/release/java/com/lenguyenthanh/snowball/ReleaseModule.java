package com.lenguyenthanh.snowball;

import android.support.annotation.NonNull;
import com.lenguyenthanh.snowball.app.config.Configuration;
import com.lenguyenthanh.snowball.app.config.Initializer;
import com.lenguyenthanh.snowball.app.config.ReleaseInitializer;
import com.lenguyenthanh.snowball.data.network.OkHttpInterceptors;
import com.lenguyenthanh.snowball.data.network.OkHttpNetworkInterceptors;
import com.lenguyenthanh.snowball.util.di.qualifier.ApiKey;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import timber.log.Timber;

import static java.util.Collections.emptyList;

@Module
@Singleton
public class ReleaseModule{

  @Provides
  @Singleton
  @NonNull
  Timber.Tree provideTimber() {
    return new Timber.Tree() {

      @Override
      protected void log(int priority, String tag, String message, Throwable t) {
        // don't do any thing
      }
    };
  }

  @Provides
  @Singleton
  @NonNull
  Initializer provideApplicationInit(ReleaseInitializer initializer){
    return initializer;
  }

  @Provides @OkHttpInterceptors
  @Singleton @NonNull
  public List<Interceptor> provideOkHttpInterceptors() {
    return emptyList();
  }

  @Provides @OkHttpNetworkInterceptors
  @Singleton @NonNull
  public List<Interceptor> provideOkHttpNetworkInterceptors() {
    return emptyList();
  }

  @Provides
  @Singleton
  @NonNull
  Configuration provideConfiguration() {
    return new Configuration.SimpleConfiguration();
  }

  @Provides
  @Singleton
  @NonNull
  @ApiKey
  String provideBaseUrl(Configuration configuration){
    return configuration.getBaseApiUrl();
  }
}
