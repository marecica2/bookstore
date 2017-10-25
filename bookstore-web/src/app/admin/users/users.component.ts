import { Component, OnInit } from "@angular/core";

import { UserService } from "./user.service";
import { User } from "./user";

@Component( {
    selector: 'admin-users-component',
    template: `
        <div>users</div>
        <ul>
          <li *ngFor="let user of users" [class.selected]="user === selectedUser" (click)="onSelect(user)">
            <span class="badge">{{user.id}}</span> {{user.firstName}} {{user.lastName}}
            <button class="delete" (click)="delete(user); $event.stopPropagation()">block</button>    
          </li>
        </ul>        
    `,
} )
export class UsersComponent implements OnInit {
    private users: User[];

    constructor(
        private userService: UserService ) { }

    ngOnInit(): void {
        this.getUsers();
    }

    getUsers(): void {
        this.userService.getUsers().then( users => this.users = users );
    }
}