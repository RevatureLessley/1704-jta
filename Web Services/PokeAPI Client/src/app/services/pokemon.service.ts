import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Pokemon } from '../../shared/pokemon';

@Injectable()
export class PokemonService {

  readonly url: string = "http://localhost:8080/PokeAPI/rest/pokemon";

  constructor(private http:HttpClient) {}

  getPokemon(name: string): Observable<Pokemon> {
    return this.http.get<Pokemon>(this.url + "/" + name);
  }

  getAllPokemon(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.url);
  }
}
