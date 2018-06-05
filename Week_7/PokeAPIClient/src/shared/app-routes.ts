import { Routes } from '@angular/router';
import { PokemonComponent } from '../app/components/pokemon/pokemon.component';
import { PokemonListComponent } from '../app/components/pokemon-list/pokemon-list.component';

export const AppRoutes: Routes = [
    { path: '', component: PokemonComponent },
    { path: 'allPokemon', component: PokemonListComponent}
];
