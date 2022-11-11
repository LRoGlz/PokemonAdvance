/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonadvance;

import java.util.ArrayList;

/**
 *
 * @author lrosellg
 */
public class Wild extends Pokemon {
    private static ArrayList<Pokemon> wildPokemons = new ArrayList();

    public Wild(String name, int number, String type) {
        super(name, number, type);
    }
    
    public static void addWildPokemon (ArrayList<Pokemon> ps){
        wildPokemons = ps;
    } 

    public static ArrayList<Pokemon> getWildPokemons() {
        return wildPokemons;
    }

    public static void setWildPokemons(ArrayList<Pokemon> wildPokemons) {
        Wild.wildPokemons = wildPokemons;
    }
    
    

    
    
}
