import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from '../../shared/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  readonly url = 'http://localhost:8080/PokeAPI/rest/pokemon';

  constructor(private http: HttpClient) { }

  getPokemon(name: string): Observable<Pokemon> {
    return this.http.get<Pokemon>(this.url + '/' + name);
  }

  getAllPokemon(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.url);
  }
}
