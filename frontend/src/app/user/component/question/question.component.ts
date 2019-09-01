import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../../services/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  constructor(private questionService: QuestionService) { }
  token: any = localStorage.getItem("token");
  ngOnInit() {
    console.log(JSON.parse(this.token));
  }

}
