import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../../../shared/pokemon';
import { FaultMessage } from '../../../shared/fault-message';
import { PokemonService } from '../../services/pokemon.service';

@Component({
  selector: 'app-pokemon-list',
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {

  pokemonList: Pokemon[];
  isLoaded = false;
  isError = false;
  faultMessage: FaultMessage;
  imageWidth = 200;

  constructor(private pokemonService: PokemonService) { }

  ngOnInit() {
  }

  getAllPokemon() {
    this.faultMessage = null;
    this.isLoaded = false;
    this.pokemonService.getAllPokemon()
                        .subscribe(
                          data => this.pokemonList = data,
                          err => this.faultMessage = err.error
                        );
    this.isLoaded = true;
    this.isError = this.faultMessage == null ? false : true;
    this.pokemonList = null;
  }

}
