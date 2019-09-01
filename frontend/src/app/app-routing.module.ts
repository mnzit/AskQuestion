import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { AuthGuard } from './auth/auth.guard';


const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent},
  { path: "user/questions", loadChildren: () => import('./user/user.module').then(mod => mod.UserModule), canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
