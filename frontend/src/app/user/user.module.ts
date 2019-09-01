import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { QuestionComponent } from './component/question/question.component';


@NgModule({
  declarations: [QuestionComponent],
  imports: [
    CommonModule,
    UserRoutingModule
  ]
})
export class UserModule { }
