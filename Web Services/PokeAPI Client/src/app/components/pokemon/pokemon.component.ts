import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../../../shared/pokemon';
import { PokemonService } from '../../services/pokemon.service';
import { FaultMessage } from '../../../shared/fault-message';


@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})
export class PokemonComponent implements OnInit {

  name: string = "";
  pokemon: Pokemon;
  imageWidth: number = 200;
  isLoaded: boolean;
  isError: boolean;
  faultMessage: FaultMessage;

  constructor(private pokemonService: PokemonService) { }

  ngOnInit() {
  }

  getPokemon() {
    this.faultMessage = null;
    this.isLoaded = false;
    this.pokemonService.getPokemon(this.name.slice(0,1).toUpperCase() + this.name.slice(1))
                       .subscribe(
                         data => this.pokemon = data,
                         err => this.faultMessage = err.error
                       );
    this.isLoaded = true;
    this.isError = this.faultMessage == null ? false : true;
    this.pokemon = null;
  }
}
