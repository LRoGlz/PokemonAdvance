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
public class BBDD {
    
    private static ArrayList<Pokemon> pokemonsBBDD = new ArrayList();
    private static ArrayList<Trainer> trainersBBDD = new ArrayList();
    
    public static void addTrainer (Trainer trainer){
        trainersBBDD.add(trainer);
    }
    
    public static void addPokemon (Pokemon pokemon){
        pokemonsBBDD.add(pokemon);
    }

    public static ArrayList<Pokemon> getPokemonsBBDD() {
        return pokemonsBBDD;
    }

    public static void setPokemonsBBDD(ArrayList<Pokemon> pokemonsBBDD) {
        BBDD.pokemonsBBDD = pokemonsBBDD;
    }

    public static ArrayList<Trainer> getTrainersBBDD() {
        return trainersBBDD;
    }

    public static void setTrainersBBDD(ArrayList<Trainer> trainersBBDD) {
        BBDD.trainersBBDD = trainersBBDD;
    }
    
    
    
}
