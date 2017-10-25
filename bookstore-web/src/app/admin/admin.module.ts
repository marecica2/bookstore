import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AdminComponent } from "./admin.component";
import { UsersComponent } from "./users/users.component";
import { AdminRoutingModule } from "./admin-routing.module";
import { ProductsComponent } from './products/products.component';
import { UserService } from './users/user.service';


@NgModule( {
    imports: [
        CommonModule,
        FormsModule,
        AdminRoutingModule
    ],
    declarations: [
        AdminComponent,
        UsersComponent,
        ProductsComponent,
    ],
    providers: [
        UserService
    ]
} )
export class AdminModule { }
