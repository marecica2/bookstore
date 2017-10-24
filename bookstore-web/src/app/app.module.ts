import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { provideRoutes } from '@angular/router';

import { AppComponent } from './app.component';
import { AppRoutingModule } from "./app-routing.module";
import { HomeComponent } from "./home.component";
import { PageNotFoundComponent } from './page-not-found.component';

@NgModule( {
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        CommonModule,
        RouterModule,
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        PageNotFoundComponent
    ],
    providers: [],
    bootstrap: [AppComponent]
} )
export class AppModule { }