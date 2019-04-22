import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TweetService} from './service/tweet.service';
import {DatePipe, HashLocationStrategy, LocationStrategy} from '@angular/common';
import {OverviewComponent} from './component/overview/overview.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {ApiInterceptor} from './interceptor/api.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    OverviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    TweetService,
    DatePipe,
    {provide: HTTP_INTERCEPTORS, useClass: ApiInterceptor, multi: true},
    {provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
