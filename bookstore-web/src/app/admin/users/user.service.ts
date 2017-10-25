import { Injectable } from "@angular/core";
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { User } from "./user";

@Injectable()
export class UserService {
    private usersUrl = "/api/bookstore/bookstore/customers";
    private headers = new Headers( { 'Content-Type': 'application/json' } );

    constructor(
        private http: Http,
    ) { }

    getUsers(): Promise<User[]> {
        return this.http.get( this.usersUrl )
            .toPromise()
            .then( response => response.json().data as User[] )
            .catch( this.handleError );
    }
    
    private handleError( error: any ): Promise<any> {
        console.error( 'An error occurred', error );
        return Promise.reject( error.message || error );
    }    
}