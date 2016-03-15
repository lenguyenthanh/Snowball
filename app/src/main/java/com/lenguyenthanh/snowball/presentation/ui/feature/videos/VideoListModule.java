package com.lenguyenthanh.snowball.presentation.ui.feature.videos;

import android.app.Activity;
import com.lenguyenthanh.snowball.data.feature.video.VideoRepositoryImpl;
import com.lenguyenthanh.snowball.di.scope.ActivityScope;
import com.lenguyenthanh.snowball.domain.UseCase;
import com.lenguyenthanh.snowball.domain.video.GetVideoList;
import com.lenguyenthanh.snowball.domain.video.VideoRepository;
import com.lenguyenthanh.snowball.presentation.ui.base.ActivityModule;
import com.lenguyenthanh.snowball.presentation.util.ui.NavigationCommand;
import dagger.Module;
import dagger.Provides;

@Module
public class VideoListModule extends ActivityModule {

  public VideoListModule(Activity activity) {
    super(activity);
  }

  @Provides
  @ActivityScope
  Activity activity() {
    return this.activity;
  }

  @Provides
  @ActivityScope
  VideoListPresenter providePresenter(VideoListPresenterImpl presenter) {
    return presenter;
  }

  @Provides
  @ActivityScope
  VideoRepository provideVideoRepository(VideoRepositoryImpl repository) {
    return repository;
  }

  @Provides
  @ActivityScope
  UseCase provideGetVideoList(GetVideoList getVideoList) {
    return getVideoList;
  }

  @Provides
  @ActivityScope
  NavigationCommand provideNavigationCommand(Activity activity){
    return new PlayVideoNavigationCommand(activity);
  }
}