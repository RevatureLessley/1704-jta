import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutes } from '../shared/app-routes';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { PokemonService } from './services/pokemon.service';
import { PokemonListComponent } from './components/pokemon-list/pokemon-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PokemonComponent,
    PokemonListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(AppRoutes)
  ],
  providers: [PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
