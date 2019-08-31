import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {HelloWorldDto} from '../dto/hello-world.dto';
import {catchError, tap} from 'rxjs/operators';

const httpJsonHeaders = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {
  }

  private static log(message: string) {
    console.log(`HttpService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      HttpService.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  public get(): Observable<HelloWorldDto[]> {
    return this.http.get<HelloWorldDto[]>('http://localhost:8080/api/hello-world')
      .pipe(
        tap(_ => HttpService.log('tap: get list')),
        catchError(this.handleError<HelloWorldDto[]>('get list', new Array<HelloWorldDto>()))
      );
  }

}
