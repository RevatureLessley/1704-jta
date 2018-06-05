import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../../shared/pokemon';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {

  pokemonList: Pokemon[];
  imageWidth: number = 250;
  imageHeight: number = 250;
  isLoaded: boolean = false;

  constructor(private pokemonService: PokemonService) { }

  ngOnInit() {
    this.pokemonService.getAllPokemon()
                .subscribe(
                  data => this.pokemonList = data,
                  err => console.log(err.error)
                )
    this.isLoaded = true;
  }

}
