import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { HeaderComponent } from './components/header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SocialmediaComponent } from './components/socialmedia/socialmedia.component';
import { UploadboxComponent } from './components/uploadbox/uploadbox.component';
import { LoginComponent } from './components/login/login.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {MatMenuModule} from '@angular/material/menu';
import { PlayerComponent } from './components/player/player.component';
import { AnalyticsComponent } from './components/analytics/analytics.component';
import { AccountComponent } from './components/account/account.component';
import { FilesComponent } from './components/files/files.component';
import { SupportComponent } from './components/support/support.component';
import { FooterComponent } from './components/footer/footer.component';
import { MembershipComponent } from './components/membership/membership.component';
import { ContentComponent } from './components/content/content.component';
import { FaqsComponent } from './components/faqs/faqs.component';
import { PlansComponent } from './components/plans/plans.component';
import { FeedbacksComponent } from './components/feedbacks/feedbacks.component';
import { TermsComponent } from './components/terms/terms.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SocialmediaComponent,
    UploadboxComponent,
    LoginComponent,
    AuthenticationComponent,
    SignupComponent,
    DashboardComponent,
    PlayerComponent,
    AnalyticsComponent,
    AccountComponent,
    FilesComponent,
    SupportComponent,
    FooterComponent,
    MembershipComponent,
    ContentComponent,
    FaqsComponent,
    PlansComponent,
    FeedbacksComponent,
    TermsComponent,
    AboutusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
