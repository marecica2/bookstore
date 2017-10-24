import { Component } from "@angular/core";

@Component( {
    template: `
        <h2>Administration</h2>
        <ul >
          <li><a routerLink="./users" routerLinkActive="active">User administration</a></li>
          <li><a routerLink="./products" routerLinkActive="active">Product administration</a></li>
        </ul>        
        <router-outlet></router-outlet>
    `,
} )
export class AdminComponent {

}