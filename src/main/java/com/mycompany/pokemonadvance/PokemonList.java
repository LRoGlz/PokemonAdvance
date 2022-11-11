/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.ArrayList;

/**
 *
 * @author igallego
 */
public class PokemonList {
    
    private ArrayList<Pokemon> pokeList = new ArrayList();

    private Pokemon pokemon1 = new Pokemon("Bulbasaur", 1, "planta");
    private Pokemon pokemon2 = new Pokemon("Charmander", 2, "fuego");
    private Pokemon pokemon3 = new Pokemon("Squirtle", 3, "agua");
    private Pokemon pokemon4 = new Pokemon("Chikorita", 4, "planta");
    private Pokemon pokemon5 = new Pokemon("Ponyta", 5, "fuego");
    private Pokemon pokemon6 = new Pokemon("Piplup", 6, "agua");
    private Pokemon pokemon7 = new Pokemon("Oddish", 7, "planta");
    private Pokemon pokemon8 = new Pokemon("Cyndaquil", 8, "fuego");
    private Pokemon pokemon9 = new Pokemon("Psyduck", 9, "agua");
    private Pokemon pokemon10 = new Pokemon("Poliwag", 10, "agua");
    
    
    public void addPokemonList(){
        pokeList.add(this.pokemon1);
        pokeList.add(this.pokemon2);
        pokeList.add(this.pokemon3);
        pokeList.add(this.pokemon4);
        pokeList.add(this.pokemon5);
        pokeList.add(this.pokemon6);
        pokeList.add(this.pokemon7);
        pokeList.add(this.pokemon8);
        pokeList.add(this.pokemon9);
        pokeList.add(this.pokemon10);
        
        
        Wild.addWildPokemon(this.pokeList);
    }

    public ArrayList<Pokemon> getPokeList() {
        return pokeList;
    }

    public void setPokeList(ArrayList<Pokemon> pokeList) {
        this.pokeList = pokeList;
    }

}
