import {Component, OnInit} from '@angular/core';
import {HttpService} from '../services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  data: any;

  constructor(private httpService: HttpService) {
  }

  ngOnInit(): void {
    this.httpService.get().subscribe(data => {
      this.data = data;
    });
  }
}
