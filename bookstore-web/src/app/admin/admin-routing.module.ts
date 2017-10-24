import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsersComponent } from "./users/users.component";
import { AdminComponent } from "./admin.component";
import { ProductsComponent } from './products/products.component';

const adminRoutes: Routes = [
    {
        path: 'admin', component: AdminComponent,
        children: [
            {
                path: 'users',
                component: UsersComponent,
            },
            {
                path: 'products',
                component: ProductsComponent,
            },
        ]
    }
];

@NgModule( {
    imports: [
        RouterModule.forChild( adminRoutes )
    ],
    exports: [
        RouterModule
    ]
} )
export class AdminRoutingModule { }
