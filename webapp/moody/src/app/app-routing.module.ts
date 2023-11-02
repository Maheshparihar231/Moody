import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AnalyticsComponent } from './components/analytics/analytics.component';
import { AccountComponent } from './components/account/account.component';
import { PlayerComponent } from './components/player/player.component';
import { FilesComponent } from './components/files/files.component';
import { SupportComponent } from './components/support/support.component';
import { FeedbacksComponent } from './components/feedbacks/feedbacks.component';
import { FaqsComponent } from './components/faqs/faqs.component';
import { PlansComponent } from './components/plans/plans.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { TermsComponent } from './components/terms/terms.component';

const routes: Routes = [
  { path: "", pathMatch: "full", redirectTo: "home" },
  { path: "home", component: HomeComponent },
  {
    path: "authentication", component: AuthenticationComponent, children: [
      { path: "", pathMatch: "full", redirectTo: "login" },
      { path: "login", component: LoginComponent },
      { path: "signup", component: SignupComponent },
    ]
  },
  {
    path: "dashboard", component: DashboardComponent, children: [
      { path: "", pathMatch: "full", redirectTo: "analytics" },
      { path: "analytics", component: AnalyticsComponent },
      { path: "account", component: AccountComponent },
      { path: "all", component: FilesComponent },
      { path: "player", component: PlayerComponent }
    ]
  },
  {
    path: "support", component: SupportComponent, children: [
      { path: "", pathMatch: 'full', redirectTo: "faqs" },
      { path: "feedback", component: FeedbacksComponent },
      { path: "faqs", component: FaqsComponent },
      { path: "plans", component: PlansComponent },
      { path: "aboutus", component: AboutusComponent },
      { path: "terms", component: TermsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
